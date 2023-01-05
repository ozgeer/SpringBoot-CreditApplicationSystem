package com.example.CreditApplicationSystem.services.givencredit;

import com.example.CreditApplicationSystem.constants.Response;
import com.example.CreditApplicationSystem.dto.credit.CreditApplyResponseDTO;
import com.example.CreditApplicationSystem.entities.Client;

public class GivenCreditIncomeBelowTenThousand implements GivenCreditType {
    @Override
    public CreditApplyResponseDTO getCreditLimit(Client client, Double deposit, Double income) {
        Double creditLimit=Double.valueOf(20000);
        if (deposit != 0) {
            Double plusage = income * 0.2;
            creditLimit +=plusage;
            return new CreditApplyResponseDTO(client, creditLimit, Response.APPROVED);
        } else {
            return new CreditApplyResponseDTO(client, creditLimit, Response.APPROVED);
        }
    }
}
