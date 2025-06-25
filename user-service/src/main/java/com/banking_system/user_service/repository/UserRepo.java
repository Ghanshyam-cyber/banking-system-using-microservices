package com.banking_system.user_service.repository;

import com.banking_system.user_service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
