package com.banking_system.transaction_service.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AccountDTO {
    private Long accountId;
    private Long userId;
    private Double amount;
}
