package com.example.travelbackend.api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tbreviewfirstsection")
public class ReviewFirstSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @Column(name = "image", columnDefinition = "TEXT")
    private String image;
    @Column(name = "orderid")
    private int orderID;

    @Column(name = "display")
    private int display = 1;
    @Column(name = "active")
    private int active = 1;

    public ReviewFirstSection(){

    }

    public ReviewFirstSection(String title, String description, String image, int orderID, int display, int active) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.orderID = orderID;
        this.display = display;
        this.active = active;
    }

    public int getDisplay() {
        return display;
    }

    public void setDisplay(int display) {
        this.display = display;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
