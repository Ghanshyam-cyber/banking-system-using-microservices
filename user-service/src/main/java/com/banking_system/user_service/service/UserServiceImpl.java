package com.banking_system.user_service.service;

import com.banking_system.user_service.entities.User;
import com.banking_system.user_service.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo){
        this.userRepo = userRepo;
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
}
