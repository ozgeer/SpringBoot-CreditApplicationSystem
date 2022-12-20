package com.example.CreditApplicationSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

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
