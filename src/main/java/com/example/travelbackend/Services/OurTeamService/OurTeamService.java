package com.example.travelbackend.Services.OurTeamService;

import com.example.travelbackend.api.models.OurTeam;
import jakarta.transaction.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface OurTeamService {

    List<OurTeam> findAll();
    @Transactional
    OurTeam addOurTeam(OurTeam ourTeam, MultipartFile imageFile);
    @Transactional
    OurTeam updateOurTeam(int id, OurTeam ourTeam, MultipartFile imageFile);
    OurTeam findById(int id);
    @Transactional
    OurTeam deleteOurTeam(int id, OurTeam ourTeam, MultipartFile imageFile);

    void updateOrderIds(List<OurTeam> ourTeams);
}
