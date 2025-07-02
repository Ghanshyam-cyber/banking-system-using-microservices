package com.banking_system.user_service.entities;

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
