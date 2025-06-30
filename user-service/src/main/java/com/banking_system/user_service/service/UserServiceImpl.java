package com.banking_system.user_service.service;

import com.banking_system.user_service.entities.User;
import com.banking_system.user_service.repository.UserRepo;
import com.banking_system.user_service.service.client.AccountClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserRepo userRepo;

    private AccountClient accountClient;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, AccountClient accountClient) {
        this.userRepo = userRepo;
        this.accountClient = accountClient;
    }


    @Override
    public User saveUser(User theUser) {
        return userRepo.save(theUser);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findById(Long theId) {
        return userRepo.findById(theId).orElseThrow(()-> new RuntimeException("User not fount with id: " + theId));
    }

    @Override
    public void deleteById(Long theId) {
        userRepo.deleteById(theId);
    }


}
