package com.example.CreditApplicationSystem.dto.client;
import lombok.Data;
import java.time.LocalDate;

@Data
public class UserCreateDTO {
    private String citizenId;
    private String name;
    private String lastName;
    private String phoneNumber;
    private Double income;
    private Double deposit;
    private LocalDate birthDate;
}
