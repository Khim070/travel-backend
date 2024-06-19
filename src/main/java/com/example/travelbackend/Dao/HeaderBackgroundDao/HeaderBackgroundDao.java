package com.example.travelbackend.Dao.HeaderBackgroundDao;

import com.example.travelbackend.api.models.HeaderBackground;

import java.util.List;

public interface HeaderBackgroundDao {
    List<HeaderBackground> findAll();
    HeaderBackground saveHeaderBackground(HeaderBackground headerBackground);
    HeaderBackground findById(int id);
}
