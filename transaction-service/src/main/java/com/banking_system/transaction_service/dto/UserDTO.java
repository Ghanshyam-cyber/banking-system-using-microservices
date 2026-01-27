package com.banking_system.transaction_service.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
    private Long userId;
    private String firstName;
    private String lastName;
}
