package com.example.travelbackend.api.controllers;

import com.example.travelbackend.Services.ContactUsDetailService.ContactUsDetailService;
import com.example.travelbackend.Services.ReviewFirstSectionService.ReviewFirstSectionService;
import com.example.travelbackend.api.models.ContactUsDetail;
import com.example.travelbackend.api.models.ReviewFirstSection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactUsDetailController {
    private ContactUsDetailService contactUsDetailService;

    @Autowired
    public ContactUsDetailController(ContactUsDetailService contactUsDetailService){
        this.contactUsDetailService = contactUsDetailService;
    }

    @GetMapping("/contactusdetail")
    public List<ContactUsDetail> getAllContactUsDetailService(){
        return contactUsDetailService.findAll();
    }

    @GetMapping("/contactusdetail/{id}")
    public ContactUsDetail getById(@PathVariable int id){
        return contactUsDetailService.findById(id);
    }

    @PostMapping("/contactusdetail")
    public ContactUsDetail addContactUsDetail(
            @RequestPart("contactusdetail") ContactUsDetail contactUsDetail,
            @RequestPart(value = "icon",required = false) MultipartFile IconFile) {
        return contactUsDetailService.addContactUsDetail(contactUsDetail, IconFile);
    }

    @PutMapping("/contactusdetail/update/{id}")
    public ContactUsDetail updateContactUsDetail(
            @PathVariable int id,
            @RequestPart("contactusdetail") ContactUsDetail contactUsDetail,
            @RequestPart(value = "icon",required = false) MultipartFile IconFile) {
        return contactUsDetailService.updateContactUsDetail(id, contactUsDetail, IconFile);
    }

    @PutMapping("/contactusdetail/updateOrderIds")
    public String updateOrderIds(@RequestBody List<ContactUsDetail> contactUsDetails) {
        contactUsDetailService.updateOrderIds(contactUsDetails);
        return "Order IDs updated!";
    }

    @PutMapping("/contactusdetail/delete/{id}")
    public ContactUsDetail deleteContactUsDetail(
            @PathVariable int id,
            @RequestPart("contactusdetail") ContactUsDetail contactUsDetail,
            @RequestPart(value = "icon",required = false) MultipartFile IconFile) {
        return contactUsDetailService.deleteContactUsDetail(id, contactUsDetail, IconFile);
    }
}