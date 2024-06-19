package com.example.travelbackend.api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tbmenubar")
public class MenuBar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "titlelink", columnDefinition = "TEXT")
    private String titleLink;
    @Column(name = "orderid")
    private int orderId;
    @Column(name = "active")
    private int active = 1;

    public MenuBar(){

    }

    public MenuBar(String title, String titleLink, int orderId, int active) {
        this.title = title;
        this.titleLink = titleLink;
        this.orderId = orderId;
        this.active = active;
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

    public String getTitleLink() {
        return titleLink;
    }

    public void setTitleLink(String titleLink) {
        this.titleLink = titleLink;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}