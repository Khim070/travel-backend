package com.example.travelbackend.Dao.ContactUsHeaderDao;

import com.example.travelbackend.api.models.ContactUsHeader;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactUsHeaderDaoImplementation implements ContactUsHeaderDao{

    private EntityManager entityManager;

    @Autowired
    public ContactUsHeaderDaoImplementation(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<ContactUsHeader> findAll() {
        TypedQuery<ContactUsHeader> query = entityManager.createQuery("SELECT c FROM ContactUsHeader c", ContactUsHeader.class);
        List<ContactUsHeader> result  = query.getResultList();
        return result;
    }

    @Override
    public ContactUsHeader saveContactUsHeader(ContactUsHeader contactUsHeader) {
        ContactUsHeader result = entityManager.merge(contactUsHeader);
        return result;
    }

    @Override
    public ContactUsHeader findById(int id) {
        ContactUsHeader result = entityManager.find(ContactUsHeader.class, id);
        return result;
    }
}
