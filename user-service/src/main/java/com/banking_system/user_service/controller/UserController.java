package com.banking_system.user_service.controller;


import com.banking_system.user_service.entities.User;
import com.banking_system.user_service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<User>> findAllUsers(){
        try {
            List<User> allUsers = userService.findAll();
            return ResponseEntity.ok(allUsers);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<User> saveUser(@RequestBody User theUser){
        try {
            User savedUser = userService.saveUser(theUser);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> findByUserId(@PathVariable Long userId){
        try {
            User user = userService.findById(userId);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }






























}
