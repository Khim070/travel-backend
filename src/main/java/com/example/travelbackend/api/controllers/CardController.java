package com.example.travelbackend.api.controllers;

import com.example.travelbackend.Services.CardService.CardService;
import com.example.travelbackend.Services.ReviewFirstSectionService.ReviewFirstSectionService;
import com.example.travelbackend.api.models.Card;
import com.example.travelbackend.api.models.ReviewFirstSection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CardController {
    private CardService cardService;

    @Autowired
    public CardController(CardService cardService){
        this.cardService = cardService;
    }

    @GetMapping("/card")
    public List<Card> getCard(){
        return cardService.findAll();
    }

    @GetMapping("/card/{id}")
    public Card getById(@PathVariable int id){
        return cardService.findById(id);
    }

    @PostMapping("/card")
    public Card addCard(
            @RequestPart("card") Card card,
            @RequestPart("cardImage") MultipartFile cardImageFile) {
        return cardService.addCard(card, cardImageFile);
    }

    @PutMapping("/card/update/{id}")
    public Card updateCard(
            @PathVariable int id,
            @RequestPart("card") Card card,
            @RequestPart("cardImage") MultipartFile cardImageFile) {
        return cardService.updateCard(id, card, cardImageFile);
    }

    @PutMapping("/card/delete/{id}")
    public Card deleteCard(
            @PathVariable int id,
            @RequestPart("card") Card card,
            @RequestPart("cardImage") MultipartFile cardImageFile) {
        return cardService.deleteCard(id, card, cardImageFile);
    }
}
