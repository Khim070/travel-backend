package com.example.travelbackend.api.controllers;

import com.example.travelbackend.Services.UserService.UserService;
import com.example.travelbackend.api.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> getUser(){
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public User getById(@PathVariable int id){
        return userService.findById(id);
    }

    @PostMapping("/user")
    public User addUser(
            @RequestPart("user") User user,
            @RequestPart(value = "photo",required = false) MultipartFile photo) {
        return userService.addUser(user, photo);
    }

    @PutMapping("/user/update/{id}")
    public User updateUser(
            @PathVariable int id,
            @RequestPart("user") User user,
            @RequestPart(value = "photo",required = false) MultipartFile photo) {
        return userService.updateUser(id, user, photo);
    }

    @PutMapping("/user/delete/{id}")
    public User deleteUser(
            @PathVariable int id,
            @RequestPart("user") User user,
            @RequestPart(value = "photo",required = false) MultipartFile photo) {
        return userService.deleteUser(id, user, photo);
    }

    @PostMapping("/user/login")
    public ResponseEntity<?> loginUser(@RequestBody User loginRequest) {
        User user = userService.findByEmail(loginRequest.getEmail());
        if (user != null && userService.verifyUserPassword(loginRequest.getEmail(), loginRequest.getPassword())) {
            return ResponseEntity.ok(new LoginResponse(true, user));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse(false, null));
        }
    }

    @PutMapping("/user/update-password")
    public ResponseEntity<?> updatePassword(
            @RequestParam String email,
            @RequestParam String oldPassword,
            @RequestParam String newPassword) {
        try {
            userService.changePassword(email, oldPassword, newPassword);
            return ResponseEntity.ok("Password updated successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    static class LoginResponse {
        private boolean success;
        private User user;

        public LoginResponse(boolean success, User user) {
            this.success = success;
            this.user = user;
        }

        public boolean isSuccess() {
            return success;
        }

        public User getUser() {
            return user;
        }
    }
}
