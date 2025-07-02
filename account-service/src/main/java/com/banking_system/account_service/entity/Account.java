package com.banking_system.account_service.entity;

import com.banking_system.account_service.enums.AccountType;
import com.banking_system.account_service.enums.ActiveType;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNumber;

    private Long accountHolderId;

    private double balance;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Enumerated(EnumType.STRING)
    private ActiveType activeType;

}
