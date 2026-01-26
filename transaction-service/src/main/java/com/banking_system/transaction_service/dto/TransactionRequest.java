package com.banking_system.transaction_service.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TransactionRequest {

    private Long fromAccountId;
    private Long toAccountId;
    private Double amount;
}
