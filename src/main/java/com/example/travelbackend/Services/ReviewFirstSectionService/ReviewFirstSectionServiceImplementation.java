package com.example.travelbackend.Services.ReviewFirstSectionService;

import com.example.travelbackend.Dao.ReviewFirstSectionDao.ReviewFirstSectionDao;
import com.example.travelbackend.api.models.ReviewFirstSection;
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
public class ReviewFirstSectionServiceImplementation implements ReviewFirstSectionService{
    @Value("${image.upload-dir}")
    private String uploadDir;
    private ReviewFirstSectionDao reviewFirstSectionDao;

    @PostConstruct
    public void init() {
        // Ensure the directory exists
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    @Autowired
    public ReviewFirstSectionServiceImplementation(ReviewFirstSectionDao reviewFirstSectionDao){
        this.reviewFirstSectionDao = reviewFirstSectionDao;
    }

    @Override
    public List<ReviewFirstSection> findAll() {
        return reviewFirstSectionDao.findAll();
    }

    @Transactional
    @Override
    public ReviewFirstSection addReviewFirstSection(ReviewFirstSection reviewFirstSection, MultipartFile imageFile) {
        if (imageFile != null && !imageFile.isEmpty()) {
            String imageFilename = imageFile.getOriginalFilename();
            Path imageFilePath = Paths.get(uploadDir, imageFilename);
            try {
                Files.copy(imageFile.getInputStream(), imageFilePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            reviewFirstSection.setImage(imageFilename);
        }

        reviewFirstSection.setId(0);
        return reviewFirstSectionDao.saveReviewFirstSection(reviewFirstSection);
    }

    @Transactional
    @Override
    public ReviewFirstSection updateReviewFirstSection(int id, ReviewFirstSection reviewFirstSection, MultipartFile imageFile) {
        if (imageFile != null && !imageFile.isEmpty()) {
            String imageFilename = imageFile.getOriginalFilename();
            Path imageFilePath = Paths.get(uploadDir, imageFilename);
            try {
                Files.copy(imageFile.getInputStream(), imageFilePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            reviewFirstSection.setImage(imageFilename);
        }

        reviewFirstSection.setId(id);
        return reviewFirstSectionDao.saveReviewFirstSection(reviewFirstSection);
    }

    @Override
    public ReviewFirstSection findById(int id) {
        return reviewFirstSectionDao.findById(id);
    }

    @Transactional
    @Override
    public ReviewFirstSection deleteReviewFirstSection(int id, ReviewFirstSection reviewFirstSection, MultipartFile imageFile) {
        if (imageFile != null && !imageFile.isEmpty()) {
            String imageFilename = imageFile.getOriginalFilename();
            Path imageFilePath = Paths.get(uploadDir, imageFilename);
            try {
                Files.copy(imageFile.getInputStream(), imageFilePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            reviewFirstSection.setImage(imageFilename);
        }

        reviewFirstSection.setId(id);
        reviewFirstSection.setActive(0);
        return reviewFirstSectionDao.saveReviewFirstSection(reviewFirstSection);
    }
}
