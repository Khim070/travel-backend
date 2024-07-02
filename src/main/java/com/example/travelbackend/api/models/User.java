package com.example.travelbackend.api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tbuser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "role")
    private String role;
    @Column(name = "photo" , columnDefinition = "TEXT")
    private String photo;
    @Column(name = "password" , columnDefinition = "TEXT")
    private String password;
    @Column(name = "usercreate")
    private int userCreate = 0;
    @Column(name = "userupdate")
    private int userUpdate = 0;
    @Column(name = "userdelete")
    private int userDelete = 0;
    @Column(name = "active")
    private int active = 1;

    public User() {

    }

    public User(String name, String email, String role, String photo, String password, int userCreate, int userUpdate, int userDelete, int active) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.photo = photo;
        this.password = password;
        this.userCreate = userCreate;
        this.userUpdate = userUpdate;
        this.userDelete = userDelete;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(int userCreate) {
        this.userCreate = userCreate;
    }

    public int getUserUpdate() {
        return userUpdate;
    }

    public void setUserUpdate(int userUpdate) {
        this.userUpdate = userUpdate;
    }

    public int getUserDelete() {
        return userDelete;
    }

    public void setUserDelete(int userDelete) {
        this.userDelete = userDelete;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
