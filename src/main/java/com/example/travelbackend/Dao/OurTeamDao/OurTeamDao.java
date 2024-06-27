package com.example.travelbackend.Dao.OurTeamDao;

import com.example.travelbackend.api.models.OurTeam;

import java.util.List;

public interface OurTeamDao {
    List<OurTeam> findAll();
    OurTeam saveOurTeam(OurTeam ourTeam);
    OurTeam findById(int id);
}
