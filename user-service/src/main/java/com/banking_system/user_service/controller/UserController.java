package com.banking_system.user_service.controller;


import com.banking_system.user_service.entities.User;
import com.banking_system.user_service.service.UserService;
import com.banking_system.user_service.service.client.AccountClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private AccountClient accountClient;

    @Autowired
    public UserController(UserService userService, AccountClient accountClient) {
        this.userService = userService;
        this.accountClient = accountClient;
    }

//    CHECK BALANCE
    @GetMapping("/{userId}/balance")
    public ResponseEntity<Double> checkBalance(@PathVariable Long userId){
        Double getBalance = accountClient.checkBalance(userId);
        
        return ResponseEntity.ok(getBalance);
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


    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long userId){
        try {
            User user = userService.findById(userId);
            if(user ==  null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else {
                userService.deleteById(userId);
                return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error deleting user with userId: " + userId);
            System.out.println("message: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }






























}
