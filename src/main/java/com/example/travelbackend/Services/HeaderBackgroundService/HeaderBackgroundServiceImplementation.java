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
import java.util.ArrayList;
import java.util.List;

@Service
public class HeaderBackgroundServiceImplementation implements HeaderBackgroundService{

    @Value("${image.upload-dir}")
    private String uploadDir;

    @Value("${server.port}")
    private String port;
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
    public HeaderBackground addHeaderBackground(HeaderBackground headerBackground, MultipartFile[] bgImageFiles, MultipartFile logoImageFiles) {
        try {
            StringBuilder bgImagePaths = new StringBuilder();
            if (bgImageFiles != null) {
                for (MultipartFile bgImageFile : bgImageFiles) {
                    if (bgImageFile != null && !bgImageFile.isEmpty()) {
                        String bgFilename = bgImageFile.getOriginalFilename();
                        Path bgFilePath = Paths.get(uploadDir, bgFilename);
                        Files.copy(bgImageFile.getInputStream(), bgFilePath, StandardCopyOption.REPLACE_EXISTING);
                        if (bgImagePaths.length() > 0) {
                            bgImagePaths.append("/");
                        }
                        bgImagePaths.append(bgFilename);
                    }
                }
            }
            headerBackground.setBgImage(bgImagePaths.length() > 0 ? bgImagePaths.toString() : null);

            if (logoImageFiles != null && !logoImageFiles.isEmpty()) {
                String logoFilename = logoImageFiles.getOriginalFilename();
                Path logoFilePath = Paths.get(uploadDir, logoFilename);
                Files.copy(logoImageFiles.getInputStream(), logoFilePath, StandardCopyOption.REPLACE_EXISTING);
                headerBackground.setLogoImage(logoFilename);
            }

            headerBackground.setId(0); // Set the ID to 0 for a new entry
            return headerBackgroundDao.saveHeaderBackground(headerBackground);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error adding HeaderBackground", e);
        }
    }

    @Transactional
    @Override
    public HeaderBackground updateHeaderBackground(int id, HeaderBackground headerBackground, MultipartFile[] bgImageFiles, MultipartFile logoImageFiles) {
        try {
            HeaderBackground existingHeaderBackground = headerBackgroundDao.findById(id);

            // Handle bgImageFiles
            StringBuilder bgImagePaths = new StringBuilder();
            if (bgImageFiles != null) {
                for (MultipartFile bgImageFile : bgImageFiles) {
                    if (bgImageFile != null && !bgImageFile.isEmpty()) {
                        String bgFilename = bgImageFile.getOriginalFilename();
                        Path bgFilePath = Paths.get(uploadDir, bgFilename);
                        Files.copy(bgImageFile.getInputStream(), bgFilePath, StandardCopyOption.REPLACE_EXISTING);
                        if (bgImagePaths.length() > 0) {
                            bgImagePaths.append("/");
                        }
                        bgImagePaths.append(bgFilename);
                    }
                }
            }
            headerBackground.setBgImage(bgImagePaths.length() > 0 ? bgImagePaths.toString() : existingHeaderBackground.getBgImage());

            if (logoImageFiles != null && !logoImageFiles.isEmpty()) {
                String logoFilename = logoImageFiles.getOriginalFilename();
                Path logoFilePath = Paths.get(uploadDir, logoFilename);
                Files.copy(logoImageFiles.getInputStream(), logoFilePath, StandardCopyOption.REPLACE_EXISTING);
                headerBackground.setLogoImage(logoFilename);
            } else {
                headerBackground.setLogoImage(existingHeaderBackground.getLogoImage());
            }
            headerBackground.setId(id);
            return headerBackgroundDao.saveHeaderBackground(headerBackground);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating HeaderBackground", e);
        }
    }

    @Override
    public HeaderBackground findById(int id) {
        return headerBackgroundDao.findById(id);
    }

    @Transactional
    @Override
    public HeaderBackground deleteHeaderBackground(int id, HeaderBackground headerBackground) {

        HeaderBackground existingHeaderBackground = headerBackgroundDao.findById(id);
        if (existingHeaderBackground != null) {
            existingHeaderBackground.setActive(headerBackground.getActive());
            headerBackgroundDao.saveHeaderBackground(existingHeaderBackground);
            return existingHeaderBackground;
        }
        return null;
    }
}
