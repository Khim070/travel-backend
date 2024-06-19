package com.example.travelbackend.Dao.MenuBarDao;

import com.example.travelbackend.api.models.MenuBar;

import java.util.List;

public interface MenuBarDao {
    List<MenuBar> findAll();
    MenuBar saveMenuBar(MenuBar menuBar);
    MenuBar findById(int id);
}
