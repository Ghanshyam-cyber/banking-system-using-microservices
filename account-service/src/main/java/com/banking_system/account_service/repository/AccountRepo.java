package com.banking_system.account_service.repository;

import com.banking_system.account_service.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepo extends JpaRepository<Account, Long> {
    List<Account> findByAccountHolderId(Long accountHolderId);
}
