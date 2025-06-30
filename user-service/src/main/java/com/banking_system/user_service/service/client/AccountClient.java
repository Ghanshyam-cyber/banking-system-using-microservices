package com.banking_system.user_service.service.client;

import com.banking_system.user_service.entities.Account;
import com.banking_system.user_service.entities.Transaction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "ACCOUNT-SERVICE")
public interface AccountClient {

    @GetMapping("/account/user/{userId}")
    public List<Account> getAccByUserId(@PathVariable Long userId);

    @GetMapping("/account/user/balance/{userId}")
    public Double checkBalance(@PathVariable Long userId);

    @PostMapping("/account/transfer")
    public String transferById(Transaction transaction);

    @PostMapping("/account")
    public ResponseEntity<String> createAccount(@RequestBody Account account);
}
