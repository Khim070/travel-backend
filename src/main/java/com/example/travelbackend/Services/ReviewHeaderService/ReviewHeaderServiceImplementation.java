package com.example.travelbackend.Services.ReviewHeaderService;

import com.example.travelbackend.Dao.MenuBarDao.MenuBarDao;
import com.example.travelbackend.Dao.ReviewHeaderDao.ReviewHeaderDao;
import com.example.travelbackend.api.models.MenuBar;
import com.example.travelbackend.api.models.ReviewHeader;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewHeaderServiceImplementation implements ReviewHeaderService{
    private ReviewHeaderDao reviewHeaderDao;

    @Autowired
    public ReviewHeaderServiceImplementation(ReviewHeaderDao reviewHeaderDao){
        this.reviewHeaderDao = reviewHeaderDao;
    }

    @Override
    public List<ReviewHeader> findAll() {
        return reviewHeaderDao.findAll();
    }

    @Transactional
    @Override
    public ReviewHeader addReviewHeader(ReviewHeader reviewHeader) {
        reviewHeader.setId(0);
        ReviewHeader result = reviewHeaderDao.saveReviewHeader(reviewHeader);
        return result;
    }

    @Transactional
    @Override
    public ReviewHeader updateReviewHeader(int id, ReviewHeader reviewHeader) {
        reviewHeader.setId(id);
        ReviewHeader result = reviewHeaderDao.saveReviewHeader(reviewHeader);
        return result;
    }

    @Override
    public ReviewHeader findById(int id) {
        return reviewHeaderDao.findById(id);
    }

    @Transactional
    @Override
    public ReviewHeader deleteReviewHeader(int id, ReviewHeader reviewHeader) {
        reviewHeader.setId(id);
        reviewHeader.setActive(0);
        ReviewHeader result = reviewHeaderDao.saveReviewHeader(reviewHeader);
        return result;
    }
}
