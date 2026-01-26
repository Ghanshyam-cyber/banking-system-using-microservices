package com.banking_system.transaction_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "transaction")
public class Transaction {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  transactionId;

    private Long fromAccountId;

    private Long toAccountId;

    private Double amount;

    private String status;

    private String type;

    private LocalDateTime transactionDate;
}
