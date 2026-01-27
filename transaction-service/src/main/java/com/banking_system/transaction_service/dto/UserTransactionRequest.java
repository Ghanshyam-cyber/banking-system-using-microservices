package com.banking_system.transaction_service.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserTransactionRequest {

    private Long fromAccountId;
    private Long fromUserId;
    private String fromFirstName;
    private String fromLastName;
    private Long toAccountId;
    private Long toUserId;
    private String toFirstName;
    private String toLastName;
    private Double amount;

    private String status;
    private String type;
    private LocalDateTime transactionDate;
}
