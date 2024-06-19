package com.example.travelbackend.api.controllers;

import com.example.travelbackend.Services.HeaderBackgroundService.HeaderBackgroundService;
import com.example.travelbackend.api.models.HeaderBackground;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HeaderBackgroundController {
    private HeaderBackgroundService headerBackgroundService;

    @Autowired
    public HeaderBackgroundController(HeaderBackgroundService headerBackgroundService){
        this.headerBackgroundService = headerBackgroundService;
    }

    @GetMapping("/headerbackground")
    public List<HeaderBackground> getAllHeaderBackground(){
        return headerBackgroundService.findAll();
    }

    @GetMapping("/headerbackground/{id}")
    public HeaderBackground getById(@PathVariable int id){
        return headerBackgroundService.findById(id);
    }

    @PostMapping("/headerbackground")
    public HeaderBackground addHeaderBackground(
        @RequestPart("headerBackground") HeaderBackground headerBackground,
        @RequestPart("bgImage") MultipartFile bgImageFile,
        @RequestPart("logoImage") MultipartFile logoImageFile) {
        return headerBackgroundService.addHeaderBackground(headerBackground, bgImageFile, logoImageFile);
    }

    @PutMapping("/headerbackground/update/{id}")
    public HeaderBackground updateHeaderBackground(
            @PathVariable int id,
            @RequestPart("headerBackground") HeaderBackground headerBackground,
            @RequestPart("bgImage") MultipartFile bgImageFile,
            @RequestPart("logoImage") MultipartFile logoImageFile) {
            return headerBackgroundService.updateHeaderBackground(id, headerBackground, bgImageFile, logoImageFile);
    }

    @PutMapping("/headerbackground/delete/{id}")
    public HeaderBackground deleteHeaderBackground(
            @PathVariable int id,
            @RequestPart("headerBackground") HeaderBackground headerBackground,
            @RequestPart("bgImage") MultipartFile bgImageFile,
            @RequestPart("logoImage") MultipartFile logoImageFile) {
        return headerBackgroundService.deleteHeaderBackground(id, headerBackground, bgImageFile, logoImageFile);
    }
}
