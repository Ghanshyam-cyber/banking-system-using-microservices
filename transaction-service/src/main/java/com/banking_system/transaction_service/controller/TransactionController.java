package com.banking_system.transaction_service.controller;

import com.banking_system.transaction_service.dto.UserTransactionRequest;
import com.banking_system.transaction_service.entity.Transaction;
import com.banking_system.transaction_service.repository.TransactionRepo;
import com.banking_system.transaction_service.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;
    private final TransactionRepo transactionRepo;
    public TransactionController(TransactionService transactionService,  TransactionRepo transactionRepo) {
        this.transactionService = transactionService;
        this.transactionRepo = transactionRepo;
    }

    @PostMapping("/send")
    public ResponseEntity<String> transfer(@RequestBody UserTransactionRequest request){
            String response = transactionService.sendMoney(request);
            return ResponseEntity.ok(response);
    }

//    Creating transaction API
    @GetMapping("/history/{accountId}")
    public ResponseEntity<List<Transaction>> getHistory(@PathVariable("accountId") Long accountId){
        return (ResponseEntity<List<Transaction>>) transactionRepo.findByFromAccountIdOrToAccountId(accountId, accountId);
    }
}
