package com.example.travelbackend.Services.CardService;

import com.example.travelbackend.Dao.CardDao.CardDao;
import com.example.travelbackend.api.models.Card;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class CardServiceImplementation implements CardService{
    @Value("${image.upload-dir}")
    private String uploadDir;
    private CardDao cardDao;

    @PostConstruct
    public void init() {
        // Ensure the directory exists
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    @Autowired
    public CardServiceImplementation(CardDao cardDao){
        this.cardDao = cardDao;
    }

    @Override
    public List<Card> findAll() {
        return cardDao.findAll();
    }

    @Transactional
    @Override
    public Card addCard(Card card, MultipartFile cardImageFile) {
        if (cardImageFile != null && !cardImageFile.isEmpty()) {
            String cardImageFilename = cardImageFile.getOriginalFilename();
            Path cardImageFilePath = Paths.get(uploadDir, cardImageFilename);
            try {
                Files.copy(cardImageFile.getInputStream(), cardImageFilePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            card.setCardImage(cardImageFilename);
        }

        card.setId(0);
        return cardDao.saveCard(card);
    }

    @Transactional
    @Override
    public Card updateCard(int id, Card card, MultipartFile cardImageFile) {
        if (cardImageFile != null && !cardImageFile.isEmpty()) {
            String cardImageFilename = cardImageFile.getOriginalFilename();
            Path cardImageFilePath = Paths.get(uploadDir, cardImageFilename);
            try {
                Files.copy(cardImageFile.getInputStream(), cardImageFilePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            card.setCardImage(cardImageFilename);
        }

        card.setId(id);
        return cardDao.saveCard(card);
    }

    @Override
    public Card findById(int id) {
        return cardDao.findById(id);
    }

    @Transactional
    @Override
    public Card deleteCard(int id, Card card, MultipartFile cardImageFile) {
        if (cardImageFile != null && !cardImageFile.isEmpty()) {
            String cardImageFilename = cardImageFile.getOriginalFilename();
            Path cardImageFilePath = Paths.get(uploadDir, cardImageFilename);
            try {
                Files.copy(cardImageFile.getInputStream(), cardImageFilePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            card.setCardImage(cardImageFilename);
        }

        card.setId(id);
        card.setActive(0);
        return cardDao.saveCard(card);
    }
}
