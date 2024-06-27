package com.example.travelbackend.api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tbheaderbackground")
public class HeaderBackground {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "maintitle")
    private String mainTitle;
    @Column(name = "bgimage", columnDefinition = "TEXT")
    private String bgImage;

    @Column(name = "logoimage", columnDefinition = "TEXT")
    private String logoImage ;
    @Column(name = "buttontitle")
    private String buttonTitle;
    @Column(name = "buttonlink", columnDefinition = "TEXT")
    private String buttonLink;
    @Column(name = "active")
    private int active = 1;

    public HeaderBackground(){
    }

    public HeaderBackground(String mainTitle, String bgImage, String logoImage, String buttonTitle, String buttonLink, int active) {
        this.mainTitle = mainTitle;
        this.bgImage = bgImage;
        this.logoImage = logoImage;
        this.buttonTitle = buttonTitle;
        this.buttonLink = buttonLink;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    public String getBgImage() {
        return bgImage;
    }

    public void setBgImage(String bgImage) {
        this.bgImage = bgImage;
    }

    public String getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(String logoImage) {
        this.logoImage = logoImage;
    }

    public String getButtonTitle() {
        return buttonTitle;
    }

    public void setButtonTitle(String buttonTitle) {
        this.buttonTitle = buttonTitle;
    }

    public String getButtonLink() {
        return buttonLink;
    }

    public void setButtonLink(String buttonLink) {
        this.buttonLink = buttonLink;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}

