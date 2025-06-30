package com.banking_system.account_service.controller;

import com.banking_system.account_service.entity.Account;
import com.banking_system.account_service.enums.AccountType;
import com.banking_system.account_service.enums.ActiveType;
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



    @PostMapping("")
    public ResponseEntity<Account> saveAccount(@RequestBody Account account){
        try {
            Account newAccount = new Account();

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
}





































