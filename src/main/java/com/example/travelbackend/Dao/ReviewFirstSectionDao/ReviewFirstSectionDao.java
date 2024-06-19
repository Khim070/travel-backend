package com.example.travelbackend.Dao.ReviewFirstSectionDao;

import com.example.travelbackend.api.models.ReviewFirstSection;

import java.util.List;

public interface ReviewFirstSectionDao {
    List<ReviewFirstSection> findAll();
    ReviewFirstSection saveReviewFirstSection(ReviewFirstSection reviewFirstSection);
    ReviewFirstSection findById(int id);
}
