package com.example.CreditApplicationSystem.dto.client;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserUpdateDTO {
    private String name;
    private String lastName;
    private String phoneNumber;
    private Double income;
    private Double deposit;

}
