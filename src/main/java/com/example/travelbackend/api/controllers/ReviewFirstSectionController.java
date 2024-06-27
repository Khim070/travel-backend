package com.example.travelbackend.api.controllers;

import com.example.travelbackend.Services.ReviewFirstSectionService.ReviewFirstSectionService;
import com.example.travelbackend.api.models.ReviewFirstSection;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ReviewFirstSectionController {
    private ReviewFirstSectionService reviewFirstSectionService;

    @Autowired
    public ReviewFirstSectionController(ReviewFirstSectionService reviewFirstSectionService){
        this.reviewFirstSectionService = reviewFirstSectionService;
    }

    @GetMapping("/reviewfirstsection")
    public List<ReviewFirstSection> getAllReviewFirstSectionService(){
        return reviewFirstSectionService.findAll();
    }

    @GetMapping("/reviewfirstsection/{id}")
    public ReviewFirstSection getById(@PathVariable int id){
        return reviewFirstSectionService.findById(id);
    }

    @PostMapping("/reviewfirstsection")
    public ReviewFirstSection addReviewFirstSection(
            @RequestPart("reviewfirstsection") ReviewFirstSection reviewFirstSection,
            @RequestPart("image") MultipartFile ImageFile) {
        return reviewFirstSectionService.addReviewFirstSection(reviewFirstSection, ImageFile);
    }

    @PutMapping("/reviewfirstsection/update/{id}")
    public ReviewFirstSection updateReviewFirstSection(
            @PathVariable int id,
            @RequestPart(value = "reviewfirstsection", required = false) ReviewFirstSection reviewFirstSection,
            @RequestPart(value = "image",required = false) MultipartFile ImageFile) {
        ReviewFirstSection updatedSection = reviewFirstSectionService.updateReviewFirstSection(id, reviewFirstSection, ImageFile);
        return updatedSection;
    }

    @PutMapping("/reviewfirstsection/updateOrderIds")
    public String updateOrderIds(@RequestBody List<ReviewFirstSection> reviewFirstSections) {
        reviewFirstSectionService.updateOrderIds(reviewFirstSections);
        return "Order IDs updated!";
    }

    @PutMapping("/reviewfirstsection/delete/{id}")
    public ReviewFirstSection deleteReviewFirstSection(
            @PathVariable int id,
            @RequestPart("reviewfirstsection") ReviewFirstSection reviewFirstSection,
            @RequestPart(value = "image", required = false) MultipartFile imageFile) {
        ReviewFirstSection updatedSection = reviewFirstSectionService.deleteReviewFirstSection(id, reviewFirstSection, imageFile);
        return updatedSection;
    }
}
