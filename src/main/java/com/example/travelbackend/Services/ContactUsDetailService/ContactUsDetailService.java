package com.example.travelbackend.Services.ContactUsDetailService;

import com.example.travelbackend.api.models.ContactUsDetail;
import jakarta.transaction.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ContactUsDetailService {
    List<ContactUsDetail> findAll();
    @Transactional
    ContactUsDetail addContactUsDetail(ContactUsDetail contactUsDetail, MultipartFile iconFile);
    @Transactional
    ContactUsDetail updateContactUsDetail(int id, ContactUsDetail contactUsDetail, MultipartFile iconFile);
    ContactUsDetail findById(int id);
    @Transactional
    ContactUsDetail deleteContactUsDetail(int id, ContactUsDetail contactUsDetail, MultipartFile iconFile);

}
