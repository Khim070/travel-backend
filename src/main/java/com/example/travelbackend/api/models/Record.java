package com.example.travelbackend.api.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tbrecord")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "role")
    private String role;
    @Column(name = "action")
    private String action;
    @Column(name = "form")
    private String form;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "date")
    private LocalDateTime date;
    @Column(name = "userid")
    private int userID;
    @Column(name = "username")
    private String userName;
    public Record (){

    }

    public Record(String name, String role, String action, String form, LocalDateTime date, int userID, String userName) {
        this.name = name;
        this.role = role;
        this.action = action;
        this.form = form;
        this.date = date;
        this.userID = userID;
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
