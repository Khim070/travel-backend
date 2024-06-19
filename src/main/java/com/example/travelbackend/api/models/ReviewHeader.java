package com.example.travelbackend.api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tbreviewheader")
public class ReviewHeader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "tag")
    private String tag;
    @Column(name = "color")
    private String color;
    @Column(name = "title")
    private String title;
    @Column(name = "orderid")
    private int orderID;
    @Column(name = "active")
    private int active = 1;

    public ReviewHeader(){

    }

    public ReviewHeader(String tag, String color, String title, int orderID, int active) {
        this.tag = tag;
        this.color = color;
        this.title = title;
        this.orderID = orderID;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
