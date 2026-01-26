package com.banking_system.transaction_service.service;

import com.banking_system.transaction_service.dto.TransactionRequest;

public interface TransactionService {
    String transfer(TransactionRequest request);
}
