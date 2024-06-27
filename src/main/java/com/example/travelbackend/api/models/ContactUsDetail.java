package com.example.travelbackend.api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tbcontactusdetail")
public class ContactUsDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @Column(name = "icon", columnDefinition = "TEXT")
    private String icon;
    @Column(name = "link", columnDefinition = "TEXT")
    private String link;
    @Column(name = "orderid")
    private int orderID;
    @Column(name = "display")
    private int display = 1;
    @Column(name = "active")
    private int active = 1;

    public ContactUsDetail(){

    }

    public ContactUsDetail(String name, String type, String description, String icon, String link, int orderID, int display, int active) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.icon = icon;
        this.link = link;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
