package com.example.travelbackend.api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tbteam")
public class OurTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "position")
    private String position;
    @Column(name = "photo", columnDefinition = "TEXT")
    private String photo;
    @Column(name = "orderid")
    private int orderID;
    @Column(name = "display")
    private int display = 1;
    @Column(name = "active")
    private int active = 1;

    public OurTeam(){

    }

    public OurTeam(String name, String position, String photo, int orderID, int display, int active) {
        this.name = name;
        this.position = position;
        this.photo = photo;
        this.orderID = orderID;
        this.display = display;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getDisplay() {
        return display;
    }

    public void setDisplay(int display) {
        this.display = display;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
