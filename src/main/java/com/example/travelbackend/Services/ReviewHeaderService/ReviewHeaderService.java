package com.example.travelbackend.Services.ReviewHeaderService;

import com.example.travelbackend.api.models.ReviewHeader;

import java.util.List;

public interface ReviewHeaderService {
    List<ReviewHeader> findAll();
    ReviewHeader addReviewHeader(ReviewHeader reviewHeader);
    ReviewHeader updateReviewHeader(int id, ReviewHeader reviewHeader);
    ReviewHeader findById(int id);
    ReviewHeader deleteReviewHeader(int id, ReviewHeader reviewHeader);
}
