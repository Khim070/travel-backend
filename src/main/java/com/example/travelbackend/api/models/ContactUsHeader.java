package com.example.travelbackend.api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tbcontactusheader")
public class ContactUsHeader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "tag", columnDefinition = "TEXT")
    private String tag;
    @Column(name = "info")
    private String info;
    @Column(name = "buttonsend")
    private String buttonSend;
    @Column(name = "active")
    private int active = 1;

    public ContactUsHeader(){

    }

    public ContactUsHeader(String title, String tag, String info, String buttonSend, int active) {
        this.title = title;
        this.tag = tag;
        this.info = info;
        this.buttonSend = buttonSend;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getButtonSend() {
        return buttonSend;
    }

    public void setButtonSend(String buttonSend) {
        this.buttonSend = buttonSend;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
