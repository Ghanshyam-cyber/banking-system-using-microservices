package com.banking_system.user_service.entities;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class Account {
    private Long accountHolderId;
    private double balance;
    private String accountType;
    private String activeType;

    public Account(){}

    public Account(Long accountHolderId, double balance, String accountType, String activeType) {
        this.accountHolderId = accountHolderId;
        this.balance = balance;
        this.accountType = accountType;
        this.activeType = activeType;
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

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getActiveType() {
        return activeType;
    }

    public void setActiveType(String activeType) {
        this.activeType = activeType;
    }
}
