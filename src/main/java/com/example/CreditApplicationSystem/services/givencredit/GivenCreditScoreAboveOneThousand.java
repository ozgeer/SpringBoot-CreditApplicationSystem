package com.example.CreditApplicationSystem.services.givencredit;

import com.example.CreditApplicationSystem.constants.CreditLimitMultiplier;
import com.example.CreditApplicationSystem.constants.Response;
import com.example.CreditApplicationSystem.constants.creditlimitvariable.CreditScoreAboveOneThousand;
import com.example.CreditApplicationSystem.dto.credit.CreditApplyResponseDTO;
import com.example.CreditApplicationSystem.entities.Client;

public class GivenCreditScoreAboveOneThousand implements GivenCreditType {
    @Override
    public CreditApplyResponseDTO getCreditLimit(Client client, Double deposit, Double income) {
        Double creditLimit=Double.valueOf(income* CreditLimitMultiplier.creditlimitmultiplier.getValue());
        if (deposit != 0) {
            Double plusage = deposit * CreditScoreAboveOneThousand.depositmultiple.getValue();
            creditLimit +=plusage;
            return new CreditApplyResponseDTO(client, creditLimit, Response.APPROVED);
        } else {
            return new CreditApplyResponseDTO(client, creditLimit, Response.APPROVED);
        }
    }
}
