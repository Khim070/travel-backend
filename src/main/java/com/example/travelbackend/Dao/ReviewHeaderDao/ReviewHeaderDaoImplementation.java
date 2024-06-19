package com.example.travelbackend.Dao.ReviewHeaderDao;

import com.example.travelbackend.api.models.ReviewHeader;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewHeaderDaoImplementation implements ReviewHeaderDao{
    private EntityManager entityManager;

    @Autowired
    public ReviewHeaderDaoImplementation(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public List<ReviewHeader> findAll() {
        TypedQuery<ReviewHeader> query = entityManager.createQuery("SELECT r FROM ReviewHeader r", ReviewHeader.class);
        List<ReviewHeader> result  = query.getResultList();
        return result;
    }

    @Override
    public ReviewHeader saveReviewHeader(ReviewHeader reviewHeader) {
        ReviewHeader result = entityManager.merge(reviewHeader);
        return result;
    }

    @Override
    public ReviewHeader findById(int id) {
        ReviewHeader result = entityManager.find(ReviewHeader.class, id);
        return result;
    }
}
