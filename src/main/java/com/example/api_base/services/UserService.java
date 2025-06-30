package com.example.api_base.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.api_base.models.UserModel;

import com.example.api_base.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    public Optional<UserModel> getUserById(Long id) {
        if (userRepository.existsById(id)) {
            return userRepository.findById(id);
        }
        return Optional.empty();
    }

    public ArrayList<UserModel> getAllUsers() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }

    public Optional<UserModel> updateUserById(Long id, UserModel user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            return Optional.of(userRepository.save(user));
        }
        return Optional.empty();
    }

    public boolean deleteUserById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
