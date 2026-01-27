package com.banking_system.transaction_service.service;

import com.banking_system.transaction_service.dto.UserTransactionRequest;

public interface TransactionService {
//    String transfer(AccountDTO request);
    String sendMoney(UserTransactionRequest request);

//    String sendMoney(Long fromUserId, Long toUserId, Double amount);
}
