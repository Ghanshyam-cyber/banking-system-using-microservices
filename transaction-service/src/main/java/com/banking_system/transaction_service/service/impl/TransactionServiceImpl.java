package com.banking_system.transaction_service.service.impl;

import com.banking_system.transaction_service.dto.AccountDTO;
import com.banking_system.transaction_service.dto.UserDTO;
import com.banking_system.transaction_service.dto.UserTransactionRequest;
import com.banking_system.transaction_service.entity.Transaction;
import com.banking_system.transaction_service.repository.TransactionRepo;
import com.banking_system.transaction_service.service.TransactionService;
import com.banking_system.transaction_service.service.client.AccountFeignClient;
import com.banking_system.transaction_service.service.client.UserClient;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepo transactionRepo;
    private final AccountFeignClient accountClient;
    private final UserClient userClient;

    public TransactionServiceImpl(TransactionRepo transactionRepo, AccountFeignClient accountClient,  UserClient userClient) {
        this.transactionRepo = transactionRepo;
        this.accountClient = accountClient;
        this.userClient = userClient;
    }

    @Override
    public String sendMoney(UserTransactionRequest request) {

        Transaction transaction = new Transaction();
        transaction.setFromAccountId(request.getFromAccountId());
        transaction.setFromUserId(request.getFromUserId());
        transaction.setToAccountId(request.getToAccountId());
        transaction.setToUserId(request.getToUserId());
        transaction.setAmount(request.getAmount());
        transaction.setType("USER_TRANSFER");
        transaction.setTransactionDate(LocalDateTime.now());
//        transaction.setFromFirstName(request.getFromFirstName());
//        transaction.setFromLastName(request.getFromLastName());
//        transaction.setToFirstName(request.getToFirstName());
//        transaction.setToLastName(request.getToLastName());
        try {
//            Fetching sender and receiver user details
            UserDTO senderUser = userClient.getUserById(request.getFromUserId());
            UserDTO receiverUser = userClient.getUserById(request.getToUserId());
            transaction.setFromFirstName(senderUser.getFirstName());
            transaction.setFromLastName(senderUser.getLastName());
            transaction.setToFirstName(receiverUser.getFirstName());
            transaction.setToLastName(receiverUser.getLastName());
//            Fetching sender and receiver bank details
            AccountDTO senderAccount = accountClient.getAccountByUserId(request.getFromUserId());
            AccountDTO receiverAccount = accountClient.getAccountByUserId(request.getToUserId());
            transaction.setFromAccountId(senderAccount.getAccountId());
            transaction.setToAccountId(receiverAccount.getAccountId());

            System.out.println("DEBUG → accountId=" + senderAccount.getAccountId());
            System.out.println("DEBUG → amount=" + request.getAmount());
//            Performing Transfer
            accountClient.debit(senderAccount.getAccountId(), request.getAmount());
            accountClient.credit(receiverAccount.getAccountId(), request.getAmount());

//            Marking status if Successful
            transaction.setStatus("SUCCESS");
            transactionRepo.save(transaction);
            return "Money has been transferred successfully";
        } catch (Exception e) {
            transaction.setStatus("FAILURE");
            transactionRepo.save(transaction);
            throw e;
        }

    }

//    @Override
//    public String transfer(AccountDTO request) {
//
//
//        Transaction transaction = new Transaction();
//        transaction.setFromAccountId(request.getFromAccountId());
//        transaction.setToAccountId(request.getToAccountId());
//        transaction.setAmount(request.getAmount());
//        transaction.setType("TRANSFER");
//        transaction.setTransactionDate(LocalDateTime.now());
//
//        try{
////        Debit transaction
//            accountClient.debit(request.getFromAccountId(), request.getAmount());
//
////        Credit transaction
//            accountClient.credit(request.getToAccountId(), request.getAmount());
//
//            transaction.setStatus("SUCCESS");
//            transactionRepo.save(transaction);
//
//        } catch (Exception e) {
//            transaction.setStatus("FAILED");
//            transactionRepo.save(transaction);
//            throw e;
//        }
//
//
//        return "Transaction Successful.";
//    }


}
