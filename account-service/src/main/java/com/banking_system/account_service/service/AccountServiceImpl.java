package com.banking_system.account_service.service;

//import com.banking_system.account_service.dto.TransactionDTO;
import com.banking_system.account_service.entity.Account;
//import com.banking_system.account_service.entity.TransactionDetails;
import com.banking_system.account_service.repository.AccountRepo;
//import com.banking_system.account_service.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{
    private static final Double min_balance = 1000.0;
    @Autowired
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
    public double checkBalance(Long userId) {
        Optional<Account> account = accountRepo.findByUserId(userId);
        if (account == null){ throw new RuntimeException("User not Found with userId: " + userId);}
        else {
            return account.get().getAmount();
        }
    }

//    @Override
//    public void transfer(Long senderId, Long receiverId, Double amount) {
//
//    }

    @Override
    public Account getAccountByUserId(Long userId) {
        return accountRepo.findByUserId(userId).orElseThrow(()-> new RuntimeException("Account not found"));
    }

    @Override
    public void debit(Long accountId, Double amount) {
        Account account = accountRepo.findById(accountId)
                .orElseThrow(()-> new RuntimeException("Account not found"));

        Double currentBalance = account.getAmount();
        if(currentBalance == null){
            currentBalance = min_balance;
        }

        if(account.getAmount() < amount){
            throw new IllegalArgumentException("Insufficient amount");
        }
        account.setAmount((account.getAmount() - amount));
        accountRepo.save(account);
    }

    @Override
    public void credit(Long accountId, Double amount) {
        Account account = accountRepo.findById(accountId)
                .orElseThrow(()-> new RuntimeException("Account not found"));

        Double currentBalance = account.getAmount();
        if(currentBalance == null){
            currentBalance =  min_balance;
        }
        account.setAmount(account.getAmount() + amount);
        accountRepo.save(account);
    }


//    @Override
//    public String getAccountHolderName(String accountHolderName) {
//        return accountRepo.getAccountHolderName(accountHolderName);
//    }


}
//    @Override
//    public String makeTransaction(TransactionDTO transactionDTO) {
//        Account sender = accountRepo.findByAccountHolderId(transactionDTO.getFromAccountId());
//        Account receiver = accountRepo.findByAccountHolderId(transactionDTO.getToAccountId());
//        if(sender == null || receiver == null){
//            throw new RuntimeException("Sender & Receiver  Not Found");
//        }
//        if (sender.getAmount() < transactionDTO.getAmount()){
//            throw new RuntimeException("Insufficient Balance");
//        }
//
//        sender.setAmount(sender.getAmount() - transactionDTO.getAmount());
//        receiver.setAmount(receiver.getAmount() + transactionDTO.getAmount());
//
//        accountRepo.save(sender);
//        accountRepo.save(receiver);
//
//        TransactionDetails debitTransaction = TransactionDetails.builder()
//                .fromAccountId(sender.getAccountHolderId())
//                .toAccountId(receiver.getAccountHolderId())
//                .amount(transactionDTO.getAmount())
//                .transactionType("DEBIT")
//                .localDateTime(LocalDateTime.now())
//                .build();
//
//        TransactionDetails creditTransaction = TransactionDetails.builder()
//                .fromAccountId(receiver.getAccountHolderId())
//                .toAccountId(sender.getAccountHolderId())
//                .amount(transactionDTO.getAmount())
//                .transactionType("CREDIT")
//                .localDateTime(LocalDateTime.now())
//                .build();
//
//        transactionRepo.save(debitTransaction);
//        transactionRepo.save(creditTransaction);
//
//        return "Transaction completed successfully";
//    }
//
//    @Override
//    public List<TransactionDetails> getTransactionsByAccount(Long accountHolderId) {
//        List<TransactionDetails> details = transactionRepo.findByFromAccountIdOrToAccountId(accountHolderId,accountHolderId);
//        return details;
//    }
