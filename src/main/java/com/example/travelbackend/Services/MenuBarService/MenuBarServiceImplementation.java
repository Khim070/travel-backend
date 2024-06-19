package com.example.travelbackend.Services.MenuBarService;

import com.example.travelbackend.Dao.MenuBarDao.MenuBarDao;
import com.example.travelbackend.api.models.MenuBar;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuBarServiceImplementation implements MenuBarService {
    private MenuBarDao menuBarDao;

    @Autowired
    public MenuBarServiceImplementation(MenuBarDao menuBarDao){
        this.menuBarDao = menuBarDao;
    }

    @Override
    public List<MenuBar> findAll() {
        return menuBarDao.findAll();
    }

    @Transactional
    @Override
    public MenuBar addMenuBar(MenuBar menuBar) {
        menuBar.setId(0);
        MenuBar result = menuBarDao.saveMenuBar(menuBar);
        return result;
    }

    @Transactional
    @Override
    public MenuBar updateMenuBar(int id, MenuBar menuBar) {
        menuBar.setId(id);
        MenuBar result = menuBarDao.saveMenuBar(menuBar);
        return result;
    }

    @Override
    public MenuBar findById(int id) {
        return menuBarDao.findById(id);
    }

    @Transactional
    @Override
    public MenuBar deleteMenuBar(int id, MenuBar menuBar) {
        menuBar.setId(id);
        menuBar.setActive(0);
        MenuBar result = menuBarDao.saveMenuBar(menuBar);
        return result;
    }
}
