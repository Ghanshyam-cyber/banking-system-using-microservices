package com.banking_system.transaction_service.service.client;

import com.banking_system.transaction_service.dto.AccountDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "account-service")
public interface AccountFeignClient {

    @GetMapping("/account/user/{userId}")
    AccountDTO getAccountByUserId(@PathVariable("userId") Long userId);

    @PutMapping("/account/debit/{accountId}/{amount}")
    void debit(@PathVariable("accountId") Long accountId, @PathVariable("amount") Double amount);

    @PutMapping("/account/credit/{accountId}/{amount}")
    void credit(@PathVariable("accountId") Long accountId, @PathVariable("amount") Double amount);
}
