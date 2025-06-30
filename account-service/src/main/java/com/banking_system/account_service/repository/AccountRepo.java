package com.banking_system.account_service.repository;

import com.banking_system.account_service.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {
}
