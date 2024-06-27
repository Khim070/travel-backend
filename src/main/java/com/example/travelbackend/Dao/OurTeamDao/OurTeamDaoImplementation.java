package com.example.travelbackend.Dao.OurTeamDao;

import com.example.travelbackend.api.models.OurTeam;
import com.example.travelbackend.api.models.ReviewFirstSection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OurTeamDaoImplementation implements OurTeamDao{
    private EntityManager entityManager;

    @Autowired
    public OurTeamDaoImplementation(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public List<OurTeam> findAll() {
        TypedQuery<OurTeam> query = entityManager.createQuery("SELECT o FROM OurTeam o", OurTeam.class);
        List<OurTeam> result = query.getResultList();
        return result;
    }

    @Override
    public OurTeam saveOurTeam(OurTeam ourTeam) {
        OurTeam result = entityManager.merge(ourTeam);
        return result;
    }

    @Override
    public OurTeam findById(int id) {
        OurTeam result = entityManager.find(OurTeam.class, id);
        return result;
    }
}
