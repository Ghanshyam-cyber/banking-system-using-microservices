package com.banking_system.account_service.service;

import com.banking_system.account_service.dto.TransactionDTO;
import com.banking_system.account_service.entity.Account;
import com.banking_system.account_service.entity.TransactionDetails;
import com.banking_system.account_service.repository.AccountRepo;
import com.banking_system.account_service.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private final AccountRepo accountRepo;
    @Autowired
    private final TransactionRepo transactionRepo;
    @Autowired
    public AccountServiceImpl (AccountRepo accountRepo,TransactionRepo transactionRepo){
        this.accountRepo = accountRepo;
        this.transactionRepo = transactionRepo;
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

//    @Override
//    public void transfer(Long senderId, Long receiverId, Double amount) {
//
//    }

    @Override
    public List<Account> getAccountByUserId(Long accountHolderId) {
//        Account account = accountRepo.findByAccountHolderId(accountHolderId);
        return accountRepo.getAccountByAccountHolderId(accountHolderId);
    }

    @Override
    public String makeTransaction(TransactionDTO transactionDTO) {
        Account sender = accountRepo.findByAccountHolderId(transactionDTO.getFromAccountId());
        Account receiver = accountRepo.findByAccountHolderId(transactionDTO.getToAccountId());
        if(sender == null || receiver == null){
            throw new RuntimeException("Sender & Receiver  Not Found");
        }
        if (sender.getBalance() < transactionDTO.getAmount()){
            throw new RuntimeException("Insufficient Balance");
        }

        sender.setBalance(sender.getBalance() - transactionDTO.getAmount());
        receiver.setBalance(receiver.getBalance() + transactionDTO.getAmount());

        accountRepo.save(sender);
        accountRepo.save(receiver);

        TransactionDetails debitTransaction = TransactionDetails.builder()
                .fromAccountId(sender.getAccountHolderId())
                .toAccountId(receiver.getAccountHolderId())
                .amount(transactionDTO.getAmount())
                .transactionType("DEBIT")
                .localDateTime(LocalDateTime.now())
                .build();

        TransactionDetails creditTransaction = TransactionDetails.builder()
                .fromAccountId(receiver.getAccountHolderId())
                .toAccountId(sender.getAccountHolderId())
                .amount(transactionDTO.getAmount())
                .transactionType("CREDIT")
                .localDateTime(LocalDateTime.now())
                .build();

        transactionRepo.save(debitTransaction);
        transactionRepo.save(creditTransaction);

        return "Transaction completed successfully";
    }

    @Override
    public List<TransactionDetails> getTransactionsByAccount(Long accountHolderId) {
        List<TransactionDetails> details = transactionRepo.findByFromAccountIdOrToAccountId(accountHolderId,accountHolderId);
        return details;
    }

//    @Override
//    public String getAccountHolderName(String accountHolderName) {
//        return accountRepo.getAccountHolderName(accountHolderName);
//    }


}
