package com.example.travelbackend.Services.CardService;

import com.example.travelbackend.api.models.Card;
import com.example.travelbackend.api.models.ReviewFirstSection;
import jakarta.transaction.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CardService {
    List<Card> findAll();
    @Transactional
    Card addCard(Card card, MultipartFile cardImageFile);
    @Transactional
    Card updateCard(int id, Card card, MultipartFile cardImageFile);
    Card findById(int id);
    @Transactional
    Card deleteCard(int id, Card card, MultipartFile cardImageFile);

    void updateOrderIds(List<Card> cards);
}
