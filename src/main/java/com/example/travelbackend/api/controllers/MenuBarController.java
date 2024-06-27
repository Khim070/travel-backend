package com.example.travelbackend.api.controllers;

import com.example.travelbackend.Services.MenuBarService.MenuBarService;
import com.example.travelbackend.api.models.MenuBar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class MenuBarController {
    private MenuBarService menuBarService;

    @Autowired
    public MenuBarController(MenuBarService menuBarService){
        this.menuBarService = menuBarService;
    }

    @GetMapping("/menubar")
    public List<MenuBar> getAllMenuBar(){
        return menuBarService.findAll();
    }

    @GetMapping("/menubar/{id}")
    public MenuBar getById(@PathVariable int id){
        return menuBarService.findById(id);
    }

    @PostMapping("/menubar")
    public MenuBar addMenuBar(@RequestBody MenuBar menuBar){
        return menuBarService.addMenuBar(menuBar);
    }

    @PutMapping("/menubar/update/{id}")
    public MenuBar updateMenuBar(@PathVariable int id, @RequestBody MenuBar menuBar){
        return menuBarService.updateMenuBar(id, menuBar);
    }

    @PutMapping("/menubar/updateOrderIds")
    public String updateOrderIds(@RequestBody List<MenuBar> menuBars) {
        menuBarService.updateOrderIds(menuBars);
        return "Order IDs updated!";
    }

    @PutMapping("/menubar/delete/{id}")
    public MenuBar deleteMenuBar(@PathVariable int id, @RequestBody MenuBar menuBar){
        return menuBarService.deleteMenuBar(id, menuBar);
    }
}
