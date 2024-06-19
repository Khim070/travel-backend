package com.example.travelbackend.Dao.CardDao;

import com.example.travelbackend.api.models.Card;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardDaoImplementation implements CardDao{
    private EntityManager entityManager;

    @Autowired
    public CardDaoImplementation(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Card> findAll() {
        TypedQuery<Card> query = entityManager.createQuery("SELECT c FROM Card c", Card.class);
        List<Card> result  = query.getResultList();
        return result;
    }

    @Override
    public Card saveCard(Card card) {
        Card result = entityManager.merge(card);
        return result;
    }

    @Override
    public Card findById(int id) {
        Card result = entityManager.find(Card.class, id);
        return result;
    }
}
