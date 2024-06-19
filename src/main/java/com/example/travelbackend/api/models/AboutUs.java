package com.example.travelbackend.api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tbaboutus")
public class AboutUs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "tag")
    private String tag;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @Column(name = "image", columnDefinition = "TEXT")
    private String image;
    @Column(name = "active")
    private int active = 1;

    public AboutUs(){

    }

    public AboutUs(String title, String tag, String description, String image, int active) {
        this.title = title;
        this.tag = tag;
        this.description = description;
        this.image = image;
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
