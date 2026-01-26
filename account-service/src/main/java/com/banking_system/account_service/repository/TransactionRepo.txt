package com.banking_system.account_service.repository;

import com.banking_system.account_service.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepo extends JpaRepository<TransactionDetails, Long> {
    List<TransactionDetails> findByFromAccountIdOrToAccountId(Long fromAccountId,Long toAccountId);
}
