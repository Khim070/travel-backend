package com.example.travelbackend.api.models;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.RequestMapping;

@Entity
@Table(name = "tbcard")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "price")
    private Double price;
    @Column(name = "day")
    private String day;
    @Column(name = "buttonbook")
    private String buttonBook;
    @Column(name = "buttonlink", columnDefinition = "TEXT")
    private String buttonLink;
    @Column(name = "rate")
    private double rate;
    @Column(name = "type")
    private String type;
    @Column(name = "cardimage", columnDefinition = "TEXT")
    private String cardImage;
    @Column(name = "orderid")
    private int orderID;
    @Column(name = "active")
    private int active = 1;

    public Card(){

    }

    public Card(String name, String address, Double price, String day, String buttonBook, String buttonLink, double rate, String type, String cardImage, int orderID, int active) {
        this.name = name;
        this.address = address;
        this.price = price;
        this.day = day;
        this.buttonBook = buttonBook;
        this.buttonLink = buttonLink;
        this.rate = rate;
        this.type = type;
        this.cardImage = cardImage;
        this.orderID = orderID;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getButtonBook() {
        return buttonBook;
    }

    public void setButtonBook(String buttonBook) {
        this.buttonBook = buttonBook;
    }

    public String getButtonLink() {
        return buttonLink;
    }

    public void setButtonLink(String buttonLink) {
        this.buttonLink = buttonLink;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCardImage() {
        return cardImage;
    }

    public void setCardImage(String cardImage) {
        this.cardImage = cardImage;
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
