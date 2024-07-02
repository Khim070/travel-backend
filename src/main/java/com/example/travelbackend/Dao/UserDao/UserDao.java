package com.example.travelbackend.Dao.UserDao;

import com.example.travelbackend.api.models.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    User saveUser(User user);
    User findById(int id);
    User findByEmail(String email);
}
