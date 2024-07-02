package com.example.travelbackend.Services.UserService;

import com.example.travelbackend.api.models.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {

    List<User> findAll();
    @Transactional
    User addUser(User user, MultipartFile photo);
    @Transactional
    User updateUser(int id, User user, MultipartFile photo);
    User findById(int id);

    User findByEmail(String email);
    @Transactional
    User deleteUser(int id, User user, MultipartFile photo);

    boolean verifyUserPassword(String email, String rawPassword);

    boolean verifyChangePassword(String rawPassword, String encodedPassword);

    void changePassword(String email, String oldPassword, String newPassword);
}
