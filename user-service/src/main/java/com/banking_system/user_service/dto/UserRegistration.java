package com.banking_system.user_service.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserRegistration {
    private Long id;
    private String firstName;
    private String lastName;
    private String mail;
    private Long mobileNumber;
    private Long adharNumber;
    private String currentAddress;
    private String currentCity;
    private String permanentAddress;
    private String permanentCity;
//    private Long accountHolderId;
    private double balance;
    private String accountType;
    private String activeType;


}
