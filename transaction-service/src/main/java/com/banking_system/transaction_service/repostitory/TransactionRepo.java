package com.banking_system.transaction_service.repostitory;


import com.banking_system.transaction_service.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {
    List<Transaction> findFromAccountIdOrToAccountId(Long from, Long to);
}
