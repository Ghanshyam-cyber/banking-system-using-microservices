package com.banking_system.user_service.service.client;

import com.banking_system.user_service.dto.AccountDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "account-service")
public interface RegistrationClientForAccountService {
    @PostMapping("/account/register")
    public ResponseEntity<String> createAccount(@RequestBody AccountDTO account);
}
