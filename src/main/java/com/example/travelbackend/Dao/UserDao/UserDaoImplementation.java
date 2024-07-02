package com.example.travelbackend.Dao.UserDao;

import com.example.travelbackend.api.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImplementation implements UserDao{
    private EntityManager entityManager;

    @Autowired
    public UserDaoImplementation(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        List<User> result  = query.getResultList();
        return result;
    }

    @Override
    public User saveUser(User user) {
        User result = entityManager.merge(user);
        return result;
    }

    @Override
    public User findById(int id) {
        User result = entityManager.find(User.class, id);
        return result;
    }

    @Override
    public User findByEmail(String email) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
        query.setParameter("email", email);
        List<User> users = query.getResultList();
        if (users != null && !users.isEmpty()) {
            return users.get(0);
        }
        return null;
    }
}
