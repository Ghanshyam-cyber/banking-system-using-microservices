package com.banking_system.account_service.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Transaction {
    private Long senderId;
    private Long receiverId;
    private Double amount;


}
