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

    @Override
    public double checkBalance(Long accountHolderId) {
        Account account = accountRepo.findByAccountHolderId(accountHolderId);
        if (account == null){ throw new RuntimeException("User not Found with userId: " + accountHolderId);}
        return account.getBalance();
    }

    @Override
    public void transfer(Long senderId, Long receiverId, Double amount) {
        Account sender = accountRepo.findByAccountHolderId(senderId);
        Account receiver = accountRepo.findByAccountHolderId(receiverId);
        if(sender == null || receiver == null){
            throw new RuntimeException("Sender & Receiver  Not Found");
        }
        if ( amount > sender.getBalance()){
            throw new RuntimeException("Insufficient Balance");
        }

        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        accountRepo.save(sender);
        accountRepo.save(receiver);
    }

    @Override
    public List<Account> getAccountByUserId(Long accountHolderId) {
        Account account = accountRepo.findByAccountHolderId(accountHolderId);
        if(account == null){
            throw new RuntimeException("Account not found for userId: " + accountHolderId);
        }
        return accountRepo.getAccountByAccountHolderId(accountHolderId);
    }

}
