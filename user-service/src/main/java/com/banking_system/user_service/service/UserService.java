package com.banking_system.user_service.service;

import com.banking_system.user_service.entities.User;

import java.util.List;

public interface UserService {

    User saveUser(User theUser);

    List<User> findAll();

    User findById(Long theId);

    void deleteById(Long theId);

}
