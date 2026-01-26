package com.banking_system.transaction_service.controller;

import com.banking_system.transaction_service.dto.TransactionRequest;
import com.banking_system.transaction_service.entity.Transaction;
import com.banking_system.transaction_service.repostitory.TransactionRepo;
import com.banking_system.transaction_service.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final TransactionRepo transactionRepo;
    public TransactionController(TransactionService transactionService,  TransactionRepo transactionRepo) {
        this.transactionService = transactionService;
        this.transactionRepo = transactionRepo;
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody TransactionRequest request){
        return ResponseEntity.ok(transactionService.transfer(request));
    }

//    Creating transaction API
    @GetMapping("/history/{accountId}")
    public ResponseEntity<List<Transaction>> getHistory(@PathVariable("accountId") Long accountId){
        return (ResponseEntity<List<Transaction>>) transactionRepo.findFromAccountIdOrToAccountId(accountId, accountId);
    }
}
