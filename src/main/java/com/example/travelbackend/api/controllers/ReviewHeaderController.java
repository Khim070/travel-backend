package com.example.travelbackend.api.controllers;

import com.example.travelbackend.Services.ReviewHeaderService.ReviewHeaderService;
import com.example.travelbackend.api.models.ReviewHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReviewHeaderController {
    private ReviewHeaderService reviewHeaderService;

    @Autowired
    public ReviewHeaderController(ReviewHeaderService reviewHeaderService){
        this.reviewHeaderService = reviewHeaderService;
    }

    @GetMapping("/reviewheader")
    public List<ReviewHeader> getAllReviewHeader(){
        return reviewHeaderService.findAll();
    }

    @GetMapping("/reviewheader/{id}")
    public ReviewHeader getById(@PathVariable int id){
        return reviewHeaderService.findById(id);
    }

    @PostMapping("/reviewheader")
    public ReviewHeader addReviewHeader(@RequestBody ReviewHeader reviewHeader){
        return reviewHeaderService.addReviewHeader(reviewHeader);
    }

    @PutMapping("/reviewheader/update/{id}")
    public ReviewHeader updateReviewHeader(@PathVariable int id, @RequestBody ReviewHeader reviewHeader){
        return reviewHeaderService.updateReviewHeader(id, reviewHeader);
    }

    @PutMapping("/reviewheader/delete/{id}")
    public ReviewHeader deleteReviewHeader(@PathVariable int id, @RequestBody ReviewHeader reviewHeader){
        return reviewHeaderService.deleteReviewHeader(id, reviewHeader);
    }
}
