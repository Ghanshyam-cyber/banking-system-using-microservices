package com.banking_system.user_service.controller;

import com.banking_system.user_service.dto.Account;
import com.banking_system.user_service.entities.User;
import com.banking_system.user_service.dto.UserRegistration;
import com.banking_system.user_service.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import com.banking_system.user_service.service.client.AccountClient;

@RestController
@RequestMapping("users")
public class RegistrationController {
    private UserRepo userRepo;

    @Autowired
    public RegistrationController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistration userRegistration){
        User user = new User();
        user.setFirstName(userRegistration.getFirstName());
        user.setLastName(userRegistration.getLastName());
        user.setMail(userRegistration.getMail());
        user.setMobileNumber(userRegistration.getMobileNumber());
        user.setAdharNumber(userRegistration.getAdharNumber());
        user.setCurrentAddress(userRegistration.getCurrentAddress());
        user.setCurrentCity(userRegistration.getCurrentCity());
        user.setPermanentAddress(userRegistration.getPermanentAddress());
        user.setPermanentCity(userRegistration.getPermanentCity());
        User savedUser = userRepo.save(user);

        Account account = new Account();
        account.setUserId(savedUser.getUserId());
        account.setAmount(userRegistration.getAmount());


//        accountClient.createAccount(account);

        return ResponseEntity.ok("User & Account saved");


    }
}









































