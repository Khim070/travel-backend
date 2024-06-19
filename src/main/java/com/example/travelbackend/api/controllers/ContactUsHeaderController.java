package com.example.travelbackend.api.controllers;

import com.example.travelbackend.Services.ContactUsHeaderService.ContactUsHeaderService;
import com.example.travelbackend.Services.MenuBarService.MenuBarService;
import com.example.travelbackend.api.models.ContactUsHeader;
import com.example.travelbackend.api.models.MenuBar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContactUsHeaderController {
    private ContactUsHeaderService contactUsHeaderService;

    @Autowired
    public ContactUsHeaderController(ContactUsHeaderService contactUsHeaderService){
        this.contactUsHeaderService = contactUsHeaderService;
    }

    @GetMapping("/contactusheader")
    public List<ContactUsHeader> getAllContactUsHeader(){
        return contactUsHeaderService.findAll();
    }

    @GetMapping("/contactusheader/{id}")
    public ContactUsHeader getById(@PathVariable int id){
        return contactUsHeaderService.findById(id);
    }

    @PostMapping("/contactusheader")
    public ContactUsHeader addMenuBar(@RequestBody ContactUsHeader contactUsHeader){
        return contactUsHeaderService.addContactUsHeader(contactUsHeader);
    }

    @PutMapping("/contactusheader/update/{id}")
    public ContactUsHeader updateContactUsHeader(@PathVariable int id, @RequestBody ContactUsHeader contactUsHeader){
        return contactUsHeaderService.updateContactUsHeader(id, contactUsHeader);
    }

    @PutMapping("/contactusheader/delete/{id}")
    public ContactUsHeader deleteContactUsHeader(@PathVariable int id, @RequestBody ContactUsHeader contactUsHeader){
        return contactUsHeaderService.deleteContactUsHeader(id, contactUsHeader);
    }
}
