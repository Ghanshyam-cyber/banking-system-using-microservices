package com.banking_system.account_service.controller;

import com.banking_system.account_service.dto.TransactionDTO;
import com.banking_system.account_service.entity.Account;
import com.banking_system.account_service.dto.TransferDTO;
import com.banking_system.account_service.entity.TransactionDetails;
import com.banking_system.account_service.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

//    getting list of accounts by user id
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Account>> getAccountByUserId(@PathVariable Long userId){
        try {
            List<Account> newList = accountService.getAccountByUserId(userId);
            return ResponseEntity.ok(newList);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//    TRANSFER BALANCE
    @PostMapping("/transfer")
    public ResponseEntity<String> transferMoney(@RequestBody TransactionDTO transaction){
        String responce = accountService.makeTransaction(transaction);
        return ResponseEntity.ok(responce);
    }

//    GET TRANSACTION HISTORY
    @GetMapping("/{accountId}/history")
    public ResponseEntity<List<TransactionDetails>> transactionHistory(@PathVariable Long accountId){
        try {
            List<TransactionDetails> details = accountService.getTransactionsByAccount(accountId);
            return ResponseEntity.ok(details);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<Account> saveAccount(@RequestBody Account account){
        try{
            Account newAccount = accountService.create(account);
            return ResponseEntity.ok(newAccount);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Account> saveAccountWithUser(@RequestBody Account account){
        try {
            Account newAccount = new Account();
            newAccount.setAccountNumber(account.getAccountNumber());
            newAccount.setBalance(account.getBalance());
            newAccount.setAccountHolderId(account.getAccountHolderId());
            newAccount.setAccountType(account.getAccountType());
            newAccount.setActiveType(account.getActiveType());

            accountService.create(account);
            return ResponseEntity.ok(newAccount);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Account>> findAllAccounts(){
        try {
            List<Account> allAcc = accountService.findAll();
            return ResponseEntity.ok(allAcc);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Account> findByAccountNumber(@PathVariable Long accountNumber){
        try {
            Account findByNumber = accountService.getByAccountNumber(accountNumber);
            return ResponseEntity.ok(findByNumber);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user/balance/{userId}")
    public ResponseEntity<Double> getBalanceByUserId(@PathVariable Long userId){
        try {
            Double checkBalance = accountService.checkBalance(userId);
            return ResponseEntity.ok(checkBalance);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}





































