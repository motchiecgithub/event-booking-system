package com.example.assignment2.controller;
import com.example.assignment2.model.User;
import com.example.assignment2.model.UserDAO;

public class AuthController {
    public boolean register(String username, String password, String name){
        return UserDAO.register(new User(username, password, name));
    }

    public User login(String username, String password){
        return UserDAO.login(username, password);
    }
}

