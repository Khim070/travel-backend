package com.example.travelbackend.api.controllers;

import com.example.travelbackend.Services.AboutUsService.AboutUsService;
import com.example.travelbackend.api.models.AboutUs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AboutUsController {
    private AboutUsService aboutUsService;

    @Autowired
    public AboutUsController(AboutUsService aboutUsService){
        this.aboutUsService = aboutUsService;
    }

    @GetMapping("/aboutUs")
    public List<AboutUs> getAboutUs(){
        return aboutUsService.findAll();
    }

    @GetMapping("/aboutUs/{id}")
    public AboutUs getById(@PathVariable int id){
        return aboutUsService.findById(id);
    }

    @PostMapping("/aboutUs")
    public AboutUs addAboutUs(
            @RequestPart("aboutUs") AboutUs aboutUs,
            @RequestPart("aboutUsImage") MultipartFile ImageFile) {
        return aboutUsService.addAboutUs(aboutUs, ImageFile);
    }

    @PutMapping("/aboutUs/update/{id}")
    public AboutUs updateAboutUs(
            @PathVariable int id,
            @RequestPart("aboutUs") AboutUs aboutUs,
            @RequestPart("aboutUsImage") MultipartFile ImageFile) {
        return aboutUsService.updateAboutUs(id, aboutUs, ImageFile);
    }

    @PutMapping("/aboutUs/delete/{id}")
    public AboutUs deleteAboutUs(
            @PathVariable int id,
            @RequestPart("aboutUs") AboutUs aboutUs,
            @RequestPart("aboutUsImage") MultipartFile ImageFile) {
        return aboutUsService.deleteAboutUs(id, aboutUs, ImageFile);
    }
}
