package com.example.api_base.controllers;

import com.example.api_base.models.UserModel;
import com.example.api_base.services.UserService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @PostMapping()
    public UserModel saveUser(@RequestBody UserModel user) {
        return userService.saveUser(user);
    }   

}
