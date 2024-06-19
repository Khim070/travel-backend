package com.example.travelbackend.Dao.ContactUsDetailDao;

import com.example.travelbackend.api.models.ContactUsDetail;

import java.util.List;

public interface ContactUsDetailDao {
    List<ContactUsDetail> findAll();
    ContactUsDetail saveContactUsDetail(ContactUsDetail contactUsDetail);
    ContactUsDetail findById(int id);
}
