package com.example.CreditApplicationSystem.dto.credit;

import com.example.CreditApplicationSystem.constants.Response;
import com.example.CreditApplicationSystem.entities.Client;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreditApplyResponseDTO {
    private Client client;
    private Double creditLimit;
    private Response creditStatus;

    public CreditApplyResponseDTO(Client client,Double creditLimit,Response creditStatus){
        this.client=client;
        this.creditLimit=creditLimit;
        this.creditStatus=creditStatus;
    }
}
