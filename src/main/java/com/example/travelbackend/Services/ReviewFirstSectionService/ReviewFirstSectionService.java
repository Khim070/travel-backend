package com.example.travelbackend.Services.ReviewFirstSectionService;

import com.example.travelbackend.api.models.ReviewFirstSection;
import jakarta.transaction.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ReviewFirstSectionService {
    List<ReviewFirstSection> findAll();
    @Transactional
    ReviewFirstSection addReviewFirstSection(ReviewFirstSection reviewFirstSection, MultipartFile imageFile);
    @Transactional
    ReviewFirstSection updateReviewFirstSection(int id, ReviewFirstSection reviewFirstSection, MultipartFile imageFile);
    ReviewFirstSection findById(int id);
    @Transactional
    ReviewFirstSection deleteReviewFirstSection(int id, ReviewFirstSection reviewFirstSection, MultipartFile imageFile);
}
