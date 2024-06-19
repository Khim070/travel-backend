package com.example.travelbackend.Dao.ReviewHeaderDao;

import com.example.travelbackend.api.models.ReviewHeader;

import java.util.List;

public interface ReviewHeaderDao {
    List<ReviewHeader> findAll();
    ReviewHeader saveReviewHeader(ReviewHeader reviewHeader);
    ReviewHeader findById(int id);
}
