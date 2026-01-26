package com.banking_system.transaction_service.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "account-service")
public interface AccountFeignClient {

    @PutMapping("/accounts/debit/{accountId}/{amount}")
    void debit(@PathVariable("accountId") Long accountId, @PathVariable("amount") Double amount);

    @PutMapping("/accounts/credit/{accountId}/{amount}")
    void credit(@PathVariable("accountId") Long accountId, @PathVariable("amount") Double amount);
}
