package com.banking_system.user_service.controller;

import com.banking_system.user_service.entities.Account;
import com.banking_system.user_service.entities.User;
import com.banking_system.user_service.entities.UserRegistration;
import com.banking_system.user_service.repository.UserRepo;
import com.banking_system.user_service.service.client.AccountClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class RegistrationController {
    private UserRepo userRepo;
    private AccountClient accountClient;

    @Autowired
    public RegistrationController(UserRepo userRepo, AccountClient accountClient) {
        this.userRepo = userRepo;
        this.accountClient = accountClient;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistration userRegistration){
        User user = new User();
        user.setFirstName(userRegistration.getFirstName());
        user.setLastName(userRegistration.getLastName());
        user.setMobileNumber(userRegistration.getMobileNumber());
        user.setCurrentAddress(userRegistration.getCurrentAddress());
        user.setPermanentAddress(userRegistration.getPermanentAddress());
        user.setCity(userRegistration.getCity());
        User savedUser = userRepo.save(user);

        Account account = new Account();
        account.setAccountHolderId(savedUser.getId());
        account.setBalance(userRegistration.getBalance());
        account.setAccountType(userRegistration.getAccountType());
        account.setAccountType(userRegistration.getAccountType());

        accountClient.createAccount(account);

        return ResponseEntity.ok("User & Account saved");


    }
}









































