package com.banking_system.user_service.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
