package com.example.travelbackend.Services.ContactUsHeaderService;

import com.example.travelbackend.api.models.ContactUsHeader;

import java.util.List;

public interface ContactUsHeaderService {
    List<ContactUsHeader> findAll();
    ContactUsHeader addContactUsHeader(ContactUsHeader contactUsHeader);
    ContactUsHeader updateContactUsHeader(int id, ContactUsHeader contactUsHeader);
    ContactUsHeader findById(int id);
    ContactUsHeader deleteContactUsHeader(int id, ContactUsHeader contactUsHeader);
}
