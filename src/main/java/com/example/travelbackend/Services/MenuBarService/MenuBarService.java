package com.example.travelbackend.Services.MenuBarService;

import com.example.travelbackend.api.models.MenuBar;

import java.util.List;

public interface MenuBarService {
    List<MenuBar> findAll();
    MenuBar addMenuBar(MenuBar menuBar);
    MenuBar updateMenuBar(int id, MenuBar menuBar);
    MenuBar findById(int id);
    MenuBar deleteMenuBar(int id, MenuBar menuBar);
}
