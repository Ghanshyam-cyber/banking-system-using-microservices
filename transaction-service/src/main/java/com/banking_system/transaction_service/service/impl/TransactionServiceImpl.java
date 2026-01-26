package com.banking_system.transaction_service.service.impl;

import com.banking_system.transaction_service.dto.TransactionRequest;
import com.banking_system.transaction_service.entity.Transaction;
import com.banking_system.transaction_service.repostitory.TransactionRepo;
import com.banking_system.transaction_service.service.TransactionService;
import com.banking_system.transaction_service.service.client.AccountFeignClient;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepo transactionRepo;
    private final AccountFeignClient accountClient;

    public TransactionServiceImpl(TransactionRepo transactionRepo, AccountFeignClient accountClient) {
        this.transactionRepo = transactionRepo;
        this.accountClient = accountClient;
    }

    @Override
    public String transfer(TransactionRequest request) {


        Transaction transaction = new Transaction();
        transaction.setFromAccountId(request.getFromAccountId());
        transaction.setToAccountId(request.getToAccountId());
        transaction.setAmount(request.getAmount());
        transaction.setType("TRANSFER");
        transaction.setTransactionDate(LocalDateTime.now());

        try{
//        Debit transaction
            accountClient.debit(request.getFromAccountId(), request.getAmount());

//        Credit transaction
            accountClient.credit(request.getToAccountId(), request.getAmount());

            transaction.setStatus("SUCCESS");
            transactionRepo.save(transaction);

        } catch (Exception e) {
            transaction.setStatus("FAILED");
            transactionRepo.save(transaction);
            throw e;
        }


        return "Transaction Successful.";
    }
}
