package com.example.travelbackend.api.controllers;

import com.example.travelbackend.Services.OurTeamService.OurTeamService;
import com.example.travelbackend.Services.ReviewFirstSectionService.ReviewFirstSectionService;
import com.example.travelbackend.api.models.OurTeam;
import com.example.travelbackend.api.models.ReviewFirstSection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OurTeamController {
    private OurTeamService ourTeamService;

    @Autowired
    public OurTeamController(OurTeamService ourTeamService){
        this.ourTeamService = ourTeamService;
    }

    @GetMapping("/ourteam")
    public List<OurTeam> getAllOurTeam(){
        return ourTeamService.findAll();
    }

    @GetMapping("/ourteam/{id}")
    public OurTeam getById(@PathVariable int id){
        return ourTeamService.findById(id);
    }

    @PostMapping("/ourteam")
    public OurTeam addOurTeam(
            @RequestPart("ourteam") OurTeam ourTeam,
            @RequestPart("photo") MultipartFile ImageFile) {
        return ourTeamService.addOurTeam(ourTeam, ImageFile);
    }

    @PutMapping("/ourteam/update/{id}")
    public OurTeam updateOurTeam(
            @PathVariable int id,
            @RequestPart(value = "ourteam", required = false) OurTeam ourTeam,
            @RequestPart(value = "photo",required = false) MultipartFile ImageFile) {
            return ourTeamService.updateOurTeam(id, ourTeam, ImageFile);
    }

    @PutMapping("/ourteam/updateOrderIds")
    public String updateOrderIds(@RequestBody List<OurTeam> ourTeams) {
        ourTeamService.updateOrderIds(ourTeams);
        return "Order IDs updated!";
    }

    @PutMapping("/ourteam/delete/{id}")
    public OurTeam deleteOurTeam(
            @PathVariable int id,
            @RequestPart("ourteam") OurTeam ourTeam,
            @RequestPart(value = "photo", required = false) MultipartFile imageFile) {
        return ourTeamService.deleteOurTeam(id, ourTeam, imageFile);
    }
}
