package com.example.travelbackend.Dao.ReviewFirstSectionDao;

import com.example.travelbackend.api.models.ReviewFirstSection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewFirstSectionDaoImplementation implements ReviewFirstSectionDao{
    private EntityManager entityManager;
    @Autowired
    public ReviewFirstSectionDaoImplementation(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<ReviewFirstSection> findAll() {
        TypedQuery<ReviewFirstSection> query = entityManager.createQuery("SELECT f FROM ReviewFirstSection f", ReviewFirstSection.class);
        List<ReviewFirstSection> result = query.getResultList();
        return result;
    }


    @Override
    public ReviewFirstSection saveReviewFirstSection(ReviewFirstSection reviewFirstSection) {
        ReviewFirstSection result = entityManager.merge(reviewFirstSection);
        return result;
    }

    @Override
    public ReviewFirstSection findById(int id) {
        ReviewFirstSection result = entityManager.find(ReviewFirstSection.class, id);
        return result;
    }
}
