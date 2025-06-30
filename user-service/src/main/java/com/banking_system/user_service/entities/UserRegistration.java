package com.banking_system.user_service.entities;



public class UserRegistration {
    private Long id;
    private String firstName;
    private String lastName;
    private Long mobileNumber;
    private String currentAddress;
    private String permanentAddress;
    private String city;
//    private Long accountHolderId;
    private double balance;
    private String accountType;
    private String activeType;

    public UserRegistration(){}

    public UserRegistration(Long id, String firstName, String lastName, Long mobileNumber, String currentAddress, String permanentAddress, String city, double balance, String accountType, String activeType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.currentAddress = currentAddress;
        this.permanentAddress = permanentAddress;
        this.city = city;
//        this.accountHolderId = accountHolderId;
        this.balance = balance;
        this.accountType = accountType;
        this.activeType = activeType;
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

//    public Long getAccountHolderId() {
//        return accountHolderId;
//    }
//
//    public void setAccountHolderId(Long accountHolderId) {
//        this.accountHolderId = accountHolderId;
//    }

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
