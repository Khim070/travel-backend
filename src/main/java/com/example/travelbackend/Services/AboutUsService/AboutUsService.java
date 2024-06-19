package com.example.travelbackend.Services.AboutUsService;

import com.example.travelbackend.api.models.AboutUs;
import jakarta.transaction.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AboutUsService {
    List<AboutUs> findAll();
    @Transactional
    AboutUs addAboutUs(AboutUs aboutUs, MultipartFile ImageFile);
    @Transactional
    AboutUs updateAboutUs(int id, AboutUs aboutUs, MultipartFile ImageFile);
    AboutUs findById(int id);
    @Transactional
    AboutUs deleteAboutUs(int id, AboutUs aboutUs, MultipartFile ImageFile);
}
