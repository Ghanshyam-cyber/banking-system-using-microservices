package com.banking_system.account_service.dto;

import lombok.*;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransactionDTO {
    private Long fromAccountId;
    private Long toAccountId;
    private Double amount;
}
