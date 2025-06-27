package com.example.api_base.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.api_base.models.UserModel;

import com.example.api_base.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> getAllUsers() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }



}
