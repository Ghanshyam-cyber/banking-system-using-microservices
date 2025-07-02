package com.banking_system.user_service.entities;

import lombok.*;


import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UsersWithAccountDetails {
    private Long id;
    private String firstName;
    private String lastName;
    private String mail;
    private String currentCity;
    private String permanentCity;
    private  List<Account> account;

}
