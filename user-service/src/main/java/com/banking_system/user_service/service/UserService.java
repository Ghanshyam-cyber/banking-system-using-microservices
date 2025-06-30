package com.banking_system.user_service.service;

import com.banking_system.user_service.entities.User;
import com.banking_system.user_service.entities.UsersWithAccountDetails;

import java.util.List;

public interface UserService {

    User saveUser(User theUser);

    List<User> findAll();

    List<UsersWithAccountDetails> getAllAccountDetailsWithUsers();

    User findById(Long theId);

    void deleteById(Long theId);




}
