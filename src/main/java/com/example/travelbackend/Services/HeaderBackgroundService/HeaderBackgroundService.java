package com.example.travelbackend.Services.HeaderBackgroundService;

import com.example.travelbackend.api.models.HeaderBackground;
import jakarta.transaction.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
public interface HeaderBackgroundService {
    List<HeaderBackground> findAll();
    @Transactional
    HeaderBackground addHeaderBackground(HeaderBackground headerBackground, MultipartFile[] bgImageFile, MultipartFile logoImageFile);
    @Transactional
    HeaderBackground updateHeaderBackground(int id, HeaderBackground headerBackground, MultipartFile[] bgImageFile, MultipartFile logoImageFile);
    HeaderBackground findById(int id);
    @Transactional
    HeaderBackground deleteHeaderBackground(int id, HeaderBackground headerBackground);
}
