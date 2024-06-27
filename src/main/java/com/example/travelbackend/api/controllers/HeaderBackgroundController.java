package com.example.travelbackend.api.controllers;

import com.example.travelbackend.Services.HeaderBackgroundService.HeaderBackgroundService;
import com.example.travelbackend.api.models.HeaderBackground;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class HeaderBackgroundController {
    private HeaderBackgroundService headerBackgroundService;

    private final Path fileStorageLocation;

    @Value("${server.port}")
    private String port;

    @Value("${image.upload-dir}")
    private String uploadDir;


    @Autowired
    public HeaderBackgroundController(HeaderBackgroundService headerBackgroundService, @Value("${image.upload-dir}") String uploadDir){
        this.headerBackgroundService = headerBackgroundService;
        this.fileStorageLocation = Paths.get(uploadDir).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
        }
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
        @RequestPart(value = "bgImage",required = false) MultipartFile[] bgImageFile,
        @RequestPart(value = "logoImage",required = false) MultipartFile logoImageFile) {
        return headerBackgroundService.addHeaderBackground(headerBackground, bgImageFile, logoImageFile);
    }

    @PutMapping("/headerbackground/update/{id}")
    public HeaderBackground updateHeaderBackground(
            @PathVariable int id,
            @RequestPart("headerBackground") HeaderBackground headerBackground,
            @RequestPart(value = "bgImage", required = false) MultipartFile[] bgImages,
            @RequestPart(value = "logoImage", required = false) MultipartFile logoImages) {
        return headerBackgroundService.updateHeaderBackground(id, headerBackground, bgImages, logoImages);
    }

    @PutMapping("/headerbackground/delete/{id}")
    public HeaderBackground deleteHeaderBackground(
            @PathVariable int id,
            @RequestBody HeaderBackground headerBackground) {
        return headerBackgroundService.deleteHeaderBackground(id, headerBackground);
    }
}
