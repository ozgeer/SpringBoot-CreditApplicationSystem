package com.example.CreditApplicationSystem.dto.credit;

import com.example.CreditApplicationSystem.entities.Client;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreditApplyResponseDTO {
    private Client client;
    private BigDecimal creditLimit;
    private boolean creditStatus;
}
