package com.example.travelbackend.Dao.AboutUsDao;

import com.example.travelbackend.api.models.AboutUs;
import com.example.travelbackend.api.models.Card;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AboutUsDaoImplementation implements AboutUsDao {

    private EntityManager entityManager;

    @Autowired
    public AboutUsDaoImplementation(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<AboutUs> findAll() {
        TypedQuery<AboutUs> query = entityManager.createQuery("SELECT a FROM AboutUs a", AboutUs.class);
        List<AboutUs> result  = query.getResultList();
        return result;
    }

    @Override
    public AboutUs saveAboutUs(AboutUs aboutUs) {
        AboutUs result = entityManager.merge(aboutUs);
        return result;
    }

    @Override
    public AboutUs findById(int id) {
        AboutUs result = entityManager.find(AboutUs.class, id);
        return result;
    }
}
