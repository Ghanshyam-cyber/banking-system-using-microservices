package com.banking_system.account_service.service;

import com.banking_system.account_service.entity.Account;

import java.util.List;

public interface AccountService {

    Account create(Account account);

    List<Account> findAll();

    Account getByAccountNumber(Long theId);

    double checkBalance(Long accountHolderId);

    void transfer(Long senderId, Long receiverId, Double amount);

    List<Account> getAccountByUserId(Long accountHolderId);

}
