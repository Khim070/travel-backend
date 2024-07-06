package com.example.travelbackend.Services.UserService;

import com.example.travelbackend.Dao.UserDao.UserDao;
import com.example.travelbackend.api.models.User;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService{

    @Value("${image.upload-dir}")
    private String uploadDir;

    @Value("${server.port}")
    private String port;
    private UserDao userDao;

    @PostConstruct
    public void init() {
        // Ensure the directory exists
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    @Autowired
    public UserServiceImplementation(UserDao userDao){
        this.userDao = userDao;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Transactional
    @Override
    public User addUser(User user, MultipartFile photo) {
        if (photo != null && !photo.isEmpty()) {
            String photoFilename = photo.getOriginalFilename();
            Path photoFilePath = Paths.get(uploadDir, photoFilename);
            try {
                Files.copy(photo.getInputStream(), photoFilePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            user.setPhoto(photoFilename);
        }

        user.setId(0);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUserCreate(0);
        user.setUserUpdate(0);
        user.setUserDelete(0);
        return userDao.saveUser(user);
    }

    @Transactional
    @Override
    public User updateUser(int id, User user, MultipartFile photo) {
        User existingUser = userDao.findById(id);
        if (existingUser == null) {
            throw new RuntimeException("User not found");
        }

        if (photo != null && !photo.isEmpty()) {
            String photoFilename = photo.getOriginalFilename();
            Path photoFilePath = Paths.get(uploadDir, photoFilename);
            try {
                Files.copy(photo.getInputStream(), photoFilePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            user.setPhoto(photoFilename);
        } else {
            user.setPhoto(existingUser.getPhoto());
        }

        if (!user.getPassword().startsWith("$2a$")) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        user.setId(id);
        return userDao.saveUser(user);
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }
    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }
    @Transactional
    @Override
    public User deleteUser(int id, User user, MultipartFile photo) {
        User existingUser = userDao.findById(id);
        if (photo != null && !photo.isEmpty()) {
            String photoFilename = photo.getOriginalFilename();
            Path photoFilePath = Paths.get(uploadDir, photoFilename);
            try {
                Files.copy(photo.getInputStream(), photoFilePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            user.setPhoto(photoFilename);
        }else {
            user.setPhoto(existingUser.getPhoto());
        }

        user.setId(id);
        user.setActive(0);
        return userDao.saveUser(user);
    }

    @Override
    public boolean verifyUserPassword(String email, String rawPassword) {
        User user = userDao.findByEmail(email);
        if (user == null) {
            return false;
        }
        return passwordEncoder.matches(rawPassword, user.getPassword());
    }

    public User loginUser(String email, String rawPassword) {
        User user = userDao.findByEmail(email);
        if (user != null && passwordEncoder.matches(rawPassword, user.getPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public boolean verifyChangePassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
    @Transactional
    @Override
    public void changePassword(String email, String oldPassword, String newPassword) {
        User user = userDao.findByEmail(email);
        if (user == null || !passwordEncoder.matches(oldPassword, user.getPassword())) {
            throw new RuntimeException("Old password is incorrect or user not found.");
        }
        user.setPassword(passwordEncoder.encode(newPassword));
        userDao.saveUser(user);
    }
}
