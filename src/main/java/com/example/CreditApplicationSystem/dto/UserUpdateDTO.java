package com.example.CreditApplicationSystem.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserUpdateDTO {
    private String name;
    private String lastName;
    private String phoneNumber;
    private Integer income;
    private Integer deposit;

}
