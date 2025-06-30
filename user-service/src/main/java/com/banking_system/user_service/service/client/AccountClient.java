package com.banking_system.user_service.service.client;

import com.banking_system.user_service.entities.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ACCOUNT-SERVICE")
public interface AccountClient {

    @PostMapping("/account")
    public ResponseEntity<String> createAccount(@RequestBody Account account);
}
