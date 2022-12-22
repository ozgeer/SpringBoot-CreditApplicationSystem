package com.example.CreditApplicationSystem.dto.credit;

import com.example.CreditApplicationSystem.entities.Client;

import java.math.BigDecimal;

public class CreditApplyResponseDTO {
    private Client client;
    private BigDecimal creditLimit;
    private boolean creditStatus;
}
