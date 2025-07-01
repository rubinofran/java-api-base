package com.example.api_base.controllers;

import com.example.api_base.models.UserModel;
import com.example.api_base.services.UserService;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
            .<ResponseEntity<Object>>map(user -> ResponseEntity.ok(user))
            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado"));
    }

    @GetMapping()
    public ArrayList<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping()
    public UserModel saveUser(@RequestBody UserModel user) {
        return userService.saveUser(user);
    }   

    @PutMapping(path="/{id}")
    public ResponseEntity<Object> updateUserById(@PathVariable Long id, @RequestBody UserModel user) {
        return userService.updateUserById(id, user)
            .<ResponseEntity<Object>>map(updatedUser -> ResponseEntity.ok(updatedUser))
            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado"));
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        if (userService.deleteUserById(id)) {
            return ResponseEntity.ok("Usuario eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }

}
