package com.banking_system.account_service.service;

import com.banking_system.account_service.dto.TransactionDTO;
import com.banking_system.account_service.entity.Account;
import com.banking_system.account_service.entity.TransactionDetails;

import java.util.List;

public interface AccountService {

    Account create(Account account);

    List<Account> findAll();

    Account getByAccountNumber(Long theId);

    double checkBalance(Long accountHolderId);

//    void transfer(Long senderId, Long receiverId, Double amount);

    List<Account> getAccountByUserId(Long accountHolderId);

    String makeTransaction(TransactionDTO transactionDTO);

    public List<TransactionDetails> getTransactionsByAccount(Long accountHolderId);

//    void makeTransaction(Long formAccountId, Long toAccountId, Double amount);

//    String getAccountHolderName(String accountHolderName);
}
