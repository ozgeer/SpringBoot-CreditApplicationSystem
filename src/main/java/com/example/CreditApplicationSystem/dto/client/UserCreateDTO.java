package com.example.CreditApplicationSystem.dto.client;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserCreateDTO {
    private Long citizenId;
    private String name;
    private String lastname;
    private String phoneNumber;
    private Integer income;
    private Integer deposit;
    private LocalDate birthDate;
    private Integer creditScore;
}
