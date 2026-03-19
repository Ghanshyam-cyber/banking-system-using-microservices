package com.banking_system.user_service.service;

import com.banking_system.user_service.dto.AccountDTO;
import com.banking_system.user_service.entities.User;
import com.banking_system.user_service.dto.UsersWithAccountDetails;
import com.banking_system.user_service.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import com.banking_system.user_service.service.client.AccountClient;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private UserRepo userRepo;

//    private AccountClient accountClient;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
//        this.accountClient = accountClient;
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
//                List<Account> account = accountClient.getAccByUserId(user.getId());
            try {
                List<AccountDTO> account = new ArrayList<>();
                try {
//                    account = accountClient.getAccByUserId(user.getUserId());
                    // build response...
                } catch (Exception e) {
                    System.out.println("Error fetching account for userId: " + user.getUserId());
                    e.printStackTrace();
                    return null;
                }
                UsersWithAccountDetails usersWithAccountDetails = new UsersWithAccountDetails();
                usersWithAccountDetails.setUserId(user.getUserId());
                usersWithAccountDetails.setFirstName(user.getFirstName());
                usersWithAccountDetails.setLastName(user.getLastName());
                usersWithAccountDetails.setMail(user.getMail());
                usersWithAccountDetails.setCurrentCity(user.getCurrentCity());
                usersWithAccountDetails.setPermanentCity(user.getPermanentCity());
//                usersWithAccountDetails.setAccount(account);

                return usersWithAccountDetails;
            }catch (Exception e) {
            System.out.println("Error fetching account for userId: " + user.getUserId());
            e.printStackTrace();
            return null;
        }

        }).collect(Collectors.toList());
    }




    @Override
    public User findById(Long userId) {
        System.out.println("Fetching user with ID: " + userId);
        return userRepo.findById(userId)
                .orElseThrow(()-> new RuntimeException("User not fount with id: " + userId));
    }

    @Override
    public void deleteById(Long theId) {
        userRepo.deleteById(theId);
    }



}
