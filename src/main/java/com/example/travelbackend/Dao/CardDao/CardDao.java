package com.example.travelbackend.Dao.CardDao;

import com.example.travelbackend.api.models.Card;
import java.util.List;

public interface CardDao {
    List<Card> findAll();
    Card saveCard(Card card);
    Card findById(int id);
}
