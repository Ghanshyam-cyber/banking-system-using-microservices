package com.banking_system.user_service.entities;

import java.util.List;

public class UsersWithAccountDetails {
    private Long id;
    private String firstName;
    private String lastName;
    private Long mobileNumber;
    private String currentAddress;
    private String permanentAddress;
    private String city;
    private  Account account;

    public UsersWithAccountDetails(){}

    public UsersWithAccountDetails(Long id, String firstName, String lastName, Long mobileNumber, String currentAddress, String permanentAddress, String city, Account account) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.currentAddress = currentAddress;
        this.permanentAddress = permanentAddress;
        this.city = city;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setAccount(List<Account> account) {
    }
}
