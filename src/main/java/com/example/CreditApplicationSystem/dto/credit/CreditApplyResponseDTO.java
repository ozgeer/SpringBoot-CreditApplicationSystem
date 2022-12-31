package com.example.CreditApplicationSystem.dto.credit;

import com.example.CreditApplicationSystem.constants.Response;
import com.example.CreditApplicationSystem.entities.Client;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreditApplyResponseDTO {
    private Client client;
    private BigDecimal creditLimit;
    private Response creditStatus;

    public CreditApplyResponseDTO(Response creditStatus){
        this.creditStatus=creditStatus;
    }
}
