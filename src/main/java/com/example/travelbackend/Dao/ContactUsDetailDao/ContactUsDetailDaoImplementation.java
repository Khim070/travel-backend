package com.example.travelbackend.Dao.ContactUsDetailDao;

import com.example.travelbackend.api.models.ContactUsDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactUsDetailDaoImplementation implements ContactUsDetailDao {

    private EntityManager entityManager;
    @Autowired
    public ContactUsDetailDaoImplementation(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    public List<ContactUsDetail> findAll() {
        TypedQuery<ContactUsDetail> query = entityManager.createQuery("SELECT d FROM ContactUsDetail d", ContactUsDetail.class);
        List<ContactUsDetail> result = query.getResultList();
        return result;
    }

    @Override
    public ContactUsDetail saveContactUsDetail(ContactUsDetail contactUsDetail) {
        ContactUsDetail result = entityManager.merge(contactUsDetail);
        return result;
    }

    @Override
    public ContactUsDetail findById(int id) {
        ContactUsDetail result = entityManager.find(ContactUsDetail.class, id);
        return result;
    }
}
