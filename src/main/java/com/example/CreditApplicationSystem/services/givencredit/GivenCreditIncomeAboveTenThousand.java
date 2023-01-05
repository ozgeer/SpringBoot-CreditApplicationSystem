package com.example.CreditApplicationSystem.services.givencredit;

import com.example.CreditApplicationSystem.constants.CreditLimitMultiplier;
import com.example.CreditApplicationSystem.constants.Response;
import com.example.CreditApplicationSystem.dto.credit.CreditApplyResponseDTO;
import com.example.CreditApplicationSystem.entities.Client;

public class GivenCreditIncomeAboveTenThousand implements GivenCreditType {
    @Override
    public CreditApplyResponseDTO getCreditLimit(Client client, Double income, Double deposit) {
        Double creditLimit=Double.valueOf(income* CreditLimitMultiplier.creditlimitmultiplier.getValue()/2);
        if (deposit != 0) {
            Double plusage = deposit * 0.25;
            creditLimit +=plusage;
            return new CreditApplyResponseDTO(client, creditLimit, Response.APPROVED);
        } else {
            return new CreditApplyResponseDTO(client, creditLimit, Response.APPROVED);
        }
    }
}
