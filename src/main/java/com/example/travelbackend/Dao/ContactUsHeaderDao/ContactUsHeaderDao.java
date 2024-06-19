package com.example.travelbackend.Dao.ContactUsHeaderDao;

import com.example.travelbackend.api.models.ContactUsHeader;

import java.util.List;

public interface ContactUsHeaderDao {
    List<ContactUsHeader> findAll();
    ContactUsHeader saveContactUsHeader(ContactUsHeader contactUsHeader);
    ContactUsHeader findById(int id);
}
