package com.banking_system.user_service.entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Account {
    private Long accountNumber;
    private Long accountHolderId;
    private double balance;
    private String accountType;
//    private String activeType;

}
