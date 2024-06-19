package com.example.travelbackend.Services.ContactUsDetailService;

import com.example.travelbackend.Dao.ContactUsDetailDao.ContactUsDetailDao;
import com.example.travelbackend.api.models.ContactUsDetail;
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
public class ContactUsDetailServiceImplementation implements ContactUsDetailService{

    @Value("${image.upload-dir}")
    private String uploadDir;
    private ContactUsDetailDao contactUsDetailDao;

    @PostConstruct
    public void init() {
        // Ensure the directory exists
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    @Autowired
    public ContactUsDetailServiceImplementation(ContactUsDetailDao contactUsDetailDao){
        this.contactUsDetailDao = contactUsDetailDao;
    }

    @Override
    public List<ContactUsDetail> findAll() {
        return contactUsDetailDao.findAll();
    }

    @Transactional
    @Override
    public ContactUsDetail addContactUsDetail(ContactUsDetail contactUsDetail, MultipartFile iconFile) {
        if (iconFile != null && !iconFile.isEmpty()) {
            String iconFilename = iconFile.getOriginalFilename();
            Path iconFilePath = Paths.get(uploadDir, iconFilename);
            try {
                Files.copy(iconFile.getInputStream(), iconFilePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            contactUsDetail.setIcon(iconFilename);
        }

        contactUsDetail.setId(0);
        return contactUsDetailDao.saveContactUsDetail(contactUsDetail);
    }

    @Transactional
    @Override
    public ContactUsDetail updateContactUsDetail(int id, ContactUsDetail contactUsDetail, MultipartFile iconFile) {
        if (iconFile != null && !iconFile.isEmpty()) {
            String iconFilename = iconFile.getOriginalFilename();
            Path iconFilePath = Paths.get(uploadDir, iconFilename);
            try {
                Files.copy(iconFile.getInputStream(), iconFilePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            contactUsDetail.setIcon(iconFilename);
        }

        contactUsDetail.setId(id);
        return contactUsDetailDao.saveContactUsDetail(contactUsDetail);
    }

    @Override
    public ContactUsDetail findById(int id) {
        return contactUsDetailDao.findById(id);
    }

    @Transactional
    @Override
    public ContactUsDetail deleteContactUsDetail(int id, ContactUsDetail contactUsDetail, MultipartFile iconFile) {
        if (iconFile != null && !iconFile.isEmpty()) {
            String iconFilename = iconFile.getOriginalFilename();
            Path iconFilePath = Paths.get(uploadDir, iconFilename);
            try {
                Files.copy(iconFile.getInputStream(), iconFilePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            contactUsDetail.setIcon(iconFilename);
        }

        contactUsDetail.setId(id);
        contactUsDetail.setActive(0);
        return contactUsDetailDao.saveContactUsDetail(contactUsDetail);
    }
}
