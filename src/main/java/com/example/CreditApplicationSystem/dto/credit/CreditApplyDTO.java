package com.example.CreditApplicationSystem.dto.credit;

import com.example.CreditApplicationSystem.entities.Client;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreditApplyDTO {
    Client client;
    BigDecimal income;
    BigDecimal deposit;
}
