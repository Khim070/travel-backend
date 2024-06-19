package com.example.travelbackend.Dao.HeaderBackgroundDao;

import com.example.travelbackend.api.models.HeaderBackground;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HeaderBackgroundDaoImplementation implements HeaderBackgroundDao{
    private EntityManager entityManager;

    @Autowired
    public HeaderBackgroundDaoImplementation(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<HeaderBackground> findAll() {
        TypedQuery<HeaderBackground> query = entityManager.createQuery("SELECT h FROM HeaderBackground h", HeaderBackground.class);
        List<HeaderBackground> result = query.getResultList();
        return result;
    }

    @Override
    public HeaderBackground saveHeaderBackground(HeaderBackground headerBackground) {
        HeaderBackground result = entityManager.merge(headerBackground);
        return result;
    }

    @Override
    public HeaderBackground findById(int id) {
        HeaderBackground result = entityManager.find(HeaderBackground.class, id);
        return result;
    }
}
