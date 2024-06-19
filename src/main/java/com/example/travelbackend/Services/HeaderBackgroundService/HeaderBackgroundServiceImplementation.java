package com.example.travelbackend.Services.HeaderBackgroundService;

import com.example.travelbackend.Dao.HeaderBackgroundDao.HeaderBackgroundDao;
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
public class HeaderBackgroundServiceImplementation implements HeaderBackgroundService{
    @Value("${image.upload-dir}")
    private String uploadDir;
    private HeaderBackgroundDao headerBackgroundDao;

    @PostConstruct
    public void init() {
        // Ensure the directory exists
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    @Autowired
    public HeaderBackgroundServiceImplementation(HeaderBackgroundDao headerBackgroundDao){
        this.headerBackgroundDao = headerBackgroundDao;
    }

    @Override
    public List<HeaderBackground> findAll() {
        return headerBackgroundDao.findAll();
    }

    @Transactional
    @Override
    public HeaderBackground addHeaderBackground(HeaderBackground headerBackground, MultipartFile bgImageFile, MultipartFile logoImageFile){
        if (bgImageFile != null && !bgImageFile.isEmpty()) {
            String bgFilename = bgImageFile.getOriginalFilename();
            Path bgFilePath = Paths.get(uploadDir, bgFilename);
            try {
                Files.copy(bgImageFile.getInputStream(), bgFilePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            headerBackground.setBgImage(bgFilename);
        }

        if (logoImageFile != null && !logoImageFile.isEmpty()) {
            String logoFilename = logoImageFile.getOriginalFilename();
            Path logoFilePath = Paths.get(uploadDir, logoFilename);
            try {
                Files.copy(logoImageFile.getInputStream(), logoFilePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            headerBackground.setLogoImage(logoFilename);
        }

        headerBackground.setId(0);
        return headerBackgroundDao.saveHeaderBackground(headerBackground);
    }

    @Transactional
    @Override
    public HeaderBackground updateHeaderBackground(int id, HeaderBackground headerBackground, MultipartFile bgImageFile, MultipartFile logoImageFile){
        if (bgImageFile != null && !bgImageFile.isEmpty()) {
            String bgFilename = bgImageFile.getOriginalFilename();
            Path bgFilePath = Paths.get(uploadDir, bgFilename);
            try {
                Files.copy(bgImageFile.getInputStream(), bgFilePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            headerBackground.setBgImage(bgFilename);
        }

        if (logoImageFile != null && !logoImageFile.isEmpty()) {
            String logoFilename = logoImageFile.getOriginalFilename();
            Path logoFilePath = Paths.get(uploadDir, logoFilename);
            try {
                Files.copy(logoImageFile.getInputStream(), logoFilePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            headerBackground.setLogoImage(logoFilename);
        }

        headerBackground.setId(id);
        return headerBackgroundDao.saveHeaderBackground(headerBackground);
    }


    @Override
    public HeaderBackground findById(int id) {
        return headerBackgroundDao.findById(id);
    }

    @Transactional
    @Override
    public HeaderBackground deleteHeaderBackground(int id, HeaderBackground headerBackground, MultipartFile bgImageFile, MultipartFile logoImageFile) {
        if (bgImageFile != null && !bgImageFile.isEmpty()) {
            String bgFilename = bgImageFile.getOriginalFilename();
            Path bgFilePath = Paths.get(uploadDir, bgFilename);
            try {
                Files.copy(bgImageFile.getInputStream(), bgFilePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            headerBackground.setBgImage(bgFilename);
        }

        if (logoImageFile != null && !logoImageFile.isEmpty()) {
            String logoFilename = logoImageFile.getOriginalFilename();
            Path logoFilePath = Paths.get(uploadDir, logoFilename);
            try {
                Files.copy(logoImageFile.getInputStream(), logoFilePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            headerBackground.setLogoImage(logoFilename);
        }

        headerBackground.setId(id);
        headerBackground.setActive(0);
        return headerBackgroundDao.saveHeaderBackground(headerBackground);
    }
}
