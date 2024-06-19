package com.example.travelbackend.Dao.AboutUsDao;

import com.example.travelbackend.api.models.AboutUs;

import java.util.List;

public interface AboutUsDao {
    List<AboutUs> findAll();
    AboutUs saveAboutUs(AboutUs aboutUs);
    AboutUs findById(int id);
}
