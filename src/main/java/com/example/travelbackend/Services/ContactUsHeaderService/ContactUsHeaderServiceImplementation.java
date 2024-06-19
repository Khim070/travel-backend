package com.example.travelbackend.Services.ContactUsHeaderService;

import com.example.travelbackend.Dao.ContactUsHeaderDao.ContactUsHeaderDao;
import com.example.travelbackend.Dao.MenuBarDao.MenuBarDao;
import com.example.travelbackend.api.models.ContactUsHeader;
import com.example.travelbackend.api.models.MenuBar;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactUsHeaderServiceImplementation implements ContactUsHeaderService {

    private ContactUsHeaderDao contactUsHeaderDao;

    @Autowired
    public ContactUsHeaderServiceImplementation(ContactUsHeaderDao contactUsHeaderDao){
        this.contactUsHeaderDao = contactUsHeaderDao;
    }

    @Override
    public List<ContactUsHeader> findAll() {
        return contactUsHeaderDao.findAll();
    }

    @Transactional
    @Override
    public ContactUsHeader addContactUsHeader(ContactUsHeader contactUsHeader) {
        contactUsHeader.setId(0);
        ContactUsHeader result = contactUsHeaderDao.saveContactUsHeader(contactUsHeader);
        return result;
    }

    @Transactional
    @Override
    public ContactUsHeader updateContactUsHeader(int id, ContactUsHeader contactUsHeader) {
        contactUsHeader.setId(id);
        ContactUsHeader result = contactUsHeaderDao.saveContactUsHeader(contactUsHeader);
        return result;
    }

    @Override
    public ContactUsHeader findById(int id) {
        return contactUsHeaderDao.findById(id);
    }

    @Transactional
    @Override
    public ContactUsHeader deleteContactUsHeader(int id, ContactUsHeader contactUsHeader) {
        contactUsHeader.setId(id);
        contactUsHeader.setActive(0);
        ContactUsHeader result = contactUsHeaderDao.saveContactUsHeader(contactUsHeader);
        return result;
    }
}
