package com.example.travelbackend.Services.OurTeamService;

import com.example.travelbackend.Dao.OurTeamDao.OurTeamDao;
import com.example.travelbackend.Dao.ReviewFirstSectionDao.ReviewFirstSectionDao;
import com.example.travelbackend.api.models.OurTeam;
import com.example.travelbackend.api.models.ReviewFirstSection;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class OurTeamServiceImplementation implements OurTeamService{

    @Value("${image.upload-dir}")
    private String uploadDir;

    @Value("${server.port}")
    private String port;
    private OurTeamDao ourTeamDao;

    @PostConstruct
    public void init() {
        // Ensure the directory exists
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    @Autowired
    public OurTeamServiceImplementation(OurTeamDao ourTeamDao){
        this.ourTeamDao = ourTeamDao;
    }

    @Override
    public List<OurTeam> findAll() {
        return ourTeamDao.findAll();
    }

    @Transactional
    @Override
    public OurTeam addOurTeam(OurTeam ourTeam, MultipartFile imageFile) {
        if (imageFile != null && !imageFile.isEmpty()) {
            String imageFilename = imageFile.getOriginalFilename();
            Path imageFilePath = Paths.get(uploadDir, imageFilename);
            try {
                Files.copy(imageFile.getInputStream(), imageFilePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            ourTeam.setPhoto(imageFilename);
        }

        ourTeam.setId(0);
        return ourTeamDao.saveOurTeam(ourTeam);
    }

    @Transactional
    @Override
    public OurTeam updateOurTeam(int id, OurTeam ourTeam, MultipartFile imageFile) {
        OurTeam existingOurTeam = ourTeamDao.findById(id);
        if (imageFile != null && !imageFile.isEmpty()) {
            String imageFilename = imageFile.getOriginalFilename();
            Path imageFilePath = Paths.get(uploadDir, imageFilename);
            try {
                Files.copy(imageFile.getInputStream(), imageFilePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            ourTeam.setPhoto(imageFilename);
        }else {
            ourTeam.setPhoto(existingOurTeam.getPhoto());
        }

        ourTeam.setId(id);
        return ourTeamDao.saveOurTeam(ourTeam);
    }

    @Override
    public OurTeam findById(int id) {
        return ourTeamDao.findById(id);
    }

    @Transactional
    @Override
    public OurTeam deleteOurTeam(int id, OurTeam ourTeam, MultipartFile imageFile) {
        OurTeam existingOurTeam = ourTeamDao.findById(id);
        if (imageFile != null && !imageFile.isEmpty()) {
            String imageFilename = imageFile.getOriginalFilename();
            Path imageFilePath = Paths.get(uploadDir, imageFilename);
            try {
                Files.copy(imageFile.getInputStream(), imageFilePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            ourTeam.setPhoto(imageFilename);
        }else {
            ourTeam.setPhoto(existingOurTeam.getPhoto());
        }

        ourTeam.setId(id);
        ourTeam.setActive(0);
        return ourTeamDao.saveOurTeam(ourTeam);
    }

    @Transactional
    @Override
    public void updateOrderIds(List<OurTeam> ourTeams) {
        for (OurTeam ourTeam : ourTeams) {
            OurTeam existingOurTeam = ourTeamDao.findById(ourTeam.getId());
            if (existingOurTeam == null) {
                throw new RuntimeException("OurTeam not found with id: " + ourTeam.getId());
            }
            existingOurTeam.setOrderID(ourTeam.getOrderID());
            ourTeamDao.saveOurTeam(existingOurTeam);
        }
    }
}
