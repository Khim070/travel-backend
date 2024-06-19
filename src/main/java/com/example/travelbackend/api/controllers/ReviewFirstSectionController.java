package com.example.travelbackend.api.controllers;

import com.example.travelbackend.Services.HeaderBackgroundService.HeaderBackgroundService;
import com.example.travelbackend.Services.ReviewFirstSectionService.ReviewFirstSectionService;
import com.example.travelbackend.api.models.HeaderBackground;
import com.example.travelbackend.api.models.ReviewFirstSection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
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
            @RequestPart("Image") MultipartFile ImageFile) {
        return reviewFirstSectionService.addReviewFirstSection(reviewFirstSection, ImageFile);
    }

    @PutMapping("/reviewfirstsection/update/{id}")
    public ReviewFirstSection updateReviewFirstSection(
            @PathVariable int id,
            @RequestPart("reviewfirstsection") ReviewFirstSection reviewFirstSection,
            @RequestPart("Image") MultipartFile ImageFile) {
        return reviewFirstSectionService.updateReviewFirstSection(id, reviewFirstSection, ImageFile);
    }

    @PutMapping("/reviewfirstsection/delete/{id}")
    public ReviewFirstSection deleteReviewFirstSection(
            @PathVariable int id,
            @RequestPart("reviewfirstsection") ReviewFirstSection reviewFirstSection,
            @RequestPart("Image") MultipartFile ImageFile) {
    return reviewFirstSectionService.deleteReviewFirstSection(id, reviewFirstSection, ImageFile);
    }
}
