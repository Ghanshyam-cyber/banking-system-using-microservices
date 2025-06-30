package com.banking_system.user_service.service;

import com.banking_system.user_service.entities.Account;
import com.banking_system.user_service.entities.User;
import com.banking_system.user_service.entities.UsersWithAccountDetails;
import com.banking_system.user_service.repository.UserRepo;
import com.banking_system.user_service.service.client.AccountClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<UsersWithAccountDetails> getAllAccountDetailsWithUsers() {
        List<User> users =  userRepo.findAll();
        return users.stream().map(user -> {
            List<Account> account = accountClient.getAccByUserId(user.getId());
            UsersWithAccountDetails usersWithAccountDetails = new UsersWithAccountDetails();
            usersWithAccountDetails.setId(user.getId());
            usersWithAccountDetails.setFirstName(user.getFirstName());
            usersWithAccountDetails.setLastName(user.getLastName());
            usersWithAccountDetails.setMobileNumber(user.getMobileNumber());
            usersWithAccountDetails.setCurrentAddress(user.getCurrentAddress());
            usersWithAccountDetails.setPermanentAddress(user.getPermanentAddress());
            usersWithAccountDetails.setCity(user.getCity());
            usersWithAccountDetails.setAccount(account);

            return usersWithAccountDetails;

        }).collect(Collectors.toList());
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
