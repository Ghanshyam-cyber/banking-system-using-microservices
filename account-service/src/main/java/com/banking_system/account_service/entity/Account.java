package com.banking_system.account_service.entity;

import com.banking_system.account_service.enums.AccountType;
import com.banking_system.account_service.enums.ActiveType;
import jakarta.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNumber;

    private Long accountHolderId;

    private double balance;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Enumerated(EnumType.STRING)
    private ActiveType activeType;

    public Account (){}

    public Account(Long accountId, Long accountHolderId, double balance, AccountType accountType, ActiveType activeType) {
        this.accountNumber = accountId;
        this.accountHolderId = accountHolderId;
        this.balance = balance;
        this.accountType = accountType;
        this.activeType = activeType;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getAccountHolderId() {
        return accountHolderId;
    }

    public void setAccountHolderId(Long accountHolderId) {
        this.accountHolderId = accountHolderId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public ActiveType getActiveType() {
        return activeType;
    }

    public void setActiveType(ActiveType activeType) {
        this.activeType = activeType;
    }
}
