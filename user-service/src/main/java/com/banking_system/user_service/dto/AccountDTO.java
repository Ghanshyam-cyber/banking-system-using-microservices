package com.banking_system.user_service.dto;

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
//    private String accountType;
//    private String activeType;

}
