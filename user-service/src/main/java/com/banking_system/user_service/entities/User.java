package com.banking_system.user_service.entities;


import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String firstName;
    private String lastName;
    private String mail;
    private Long mobileNumber;
    private Long adharNumber;
    private String currentAddress;
    private String currentCity;
    private String permanentAddress;
    private String permanentCity;

}
