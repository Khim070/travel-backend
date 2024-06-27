package com.example.travelbackend.Services.AboutUsService;

import com.example.travelbackend.Dao.AboutUsDao.AboutUsDao;
import com.example.travelbackend.Dao.CardDao.CardDao;
import com.example.travelbackend.api.models.AboutUs;
import com.example.travelbackend.api.models.HeaderBackground;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class AboutUsServiceImplementation implements AboutUsService{

    @Value("${image.upload-dir}")
    private String uploadDir;
    private AboutUsDao aboutUsDao;

    @PostConstruct
    public void init() {
        // Ensure the directory exists
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    @Autowired
    public AboutUsServiceImplementation(AboutUsDao aboutUsDao){
        this.aboutUsDao = aboutUsDao;
    }

    @Override
    public List<AboutUs> findAll() {
        return aboutUsDao.findAll();
    }

    @Transactional
    @Override
    public AboutUs addAboutUs(AboutUs aboutUs, MultipartFile ImageFile) {
        if (ImageFile != null && !ImageFile.isEmpty()) {
            String imageFilename = ImageFile.getOriginalFilename();
            Path ImageFilePath = Paths.get(uploadDir, imageFilename);
            try {
                Files.copy(ImageFile.getInputStream(), ImageFilePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            aboutUs.setImage(imageFilename);
        }

        aboutUs.setId(0);
        return aboutUsDao.saveAboutUs(aboutUs);
    }

    @Transactional
    @Override
    public AboutUs updateAboutUs(int id, AboutUs aboutUs, MultipartFile ImageFile) {
        AboutUs existingAboutUs = aboutUsDao.findById(id);
        if (ImageFile != null && !ImageFile.isEmpty()) {
            String imageFilename = ImageFile.getOriginalFilename();
            Path imageFilePath = Paths.get(uploadDir, imageFilename);
            try {
                Files.copy(ImageFile.getInputStream(), imageFilePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            aboutUs.setImage(imageFilename);
        } else {
            aboutUs.setImage(existingAboutUs.getImage());
        }
        aboutUs.setId(id);
        return aboutUsDao.saveAboutUs(aboutUs);
    }

    @Override
    public AboutUs findById(int id) {
        return aboutUsDao.findById(id);
    }

    @Transactional
    @Override
    public AboutUs deleteAboutUs(int id, AboutUs aboutUs, MultipartFile ImageFile) {
        AboutUs existingAboutUs = aboutUsDao.findById(id);
        if (ImageFile != null && !ImageFile.isEmpty()) {
            String imageFilename = ImageFile.getOriginalFilename();
            Path imageFilePath = Paths.get(uploadDir, imageFilename);
            try {
                Files.copy(ImageFile.getInputStream(), imageFilePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            aboutUs.setImage(imageFilename);
        }else {
            aboutUs.setImage(existingAboutUs.getImage());
        }

        aboutUs.setId(id);
        aboutUs.setActive(0);
        return aboutUsDao.saveAboutUs(aboutUs);
    }
}
