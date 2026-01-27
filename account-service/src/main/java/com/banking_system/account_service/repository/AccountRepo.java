package com.banking_system.account_service.repository;

import com.banking_system.account_service.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AccountRepo extends JpaRepository<Account, Long> {

    Optional<Account> findByUserId(Long userId);
}
