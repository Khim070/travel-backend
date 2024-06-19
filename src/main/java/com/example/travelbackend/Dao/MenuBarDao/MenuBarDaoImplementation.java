package com.example.travelbackend.Dao.MenuBarDao;

import com.example.travelbackend.Dao.MenuBarDao.MenuBarDao;
import com.example.travelbackend.api.models.MenuBar;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MenuBarDaoImplementation implements MenuBarDao {
    private EntityManager entityManager;

    @Autowired
    public MenuBarDaoImplementation(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<MenuBar> findAll() {
        TypedQuery<MenuBar> query = entityManager.createQuery("SELECT m FROM MenuBar m", MenuBar.class);
        List<MenuBar> result  = query.getResultList();
        return result;
    }

    @Override
    public MenuBar saveMenuBar(MenuBar menuBar) {
        MenuBar result = entityManager.merge(menuBar);
        return result;
    }

    @Override
    public MenuBar findById(int id) {
        MenuBar result = entityManager.find(MenuBar.class, id);
        return result;
    }
}
