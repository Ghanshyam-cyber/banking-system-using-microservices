package com.banking_system.account_service.service;

import com.banking_system.account_service.entity.Account;
import com.banking_system.account_service.repository.AccountRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    private final AccountRepo accountRepo;

    public AccountServiceImpl (AccountRepo accountRepo){
        this.accountRepo = accountRepo;
    }

    @Override
    public Account create(Account account) {
        return accountRepo.save(account);
    }

    @Override
    public List<Account> findAll() {
        return accountRepo.findAll();
    }

    @Override
    public Account getByAccountNumber(Long theId) {
        return accountRepo.findById(theId).orElseThrow( () ->  new RuntimeException("Accont not found with account number: " + theId));
    }
}
