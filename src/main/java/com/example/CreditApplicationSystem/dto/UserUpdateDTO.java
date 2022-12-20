package com.example.CreditApplicationSystem.dto;

import lombok.Data;

@Data
public class UserUpdateDTO {
    private String name;
    private String lastName;
    private String phoneNumber;
    private Integer income;
    private Integer deposit;

}
