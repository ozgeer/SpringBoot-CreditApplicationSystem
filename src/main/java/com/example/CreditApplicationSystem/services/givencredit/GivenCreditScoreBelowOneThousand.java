package com.example.CreditApplicationSystem.services.givencredit;

import com.example.CreditApplicationSystem.constants.Response;
import com.example.CreditApplicationSystem.constants.creditlimitvariable.IncomeBelowFiveThousand;
import com.example.CreditApplicationSystem.dto.credit.CreditApplyResponseDTO;
import com.example.CreditApplicationSystem.entities.Client;

import java.math.BigDecimal;

public class GivenCreditScoreBelowOneThousand implements GivenCreditType {
    @Override
    public CreditApplyResponseDTO getCreditLimit(Client client, Double income, Double deposit) {
        Double creditLimit=Double.valueOf(10000);
        if (deposit != 0) {
            Double plusage = deposit * IncomeBelowFiveThousand.depositmultiple.getValue();
            creditLimit +=plusage;
            return new CreditApplyResponseDTO(client, creditLimit, Response.APPROVED);
        } else {
            return new CreditApplyResponseDTO(client, creditLimit, Response.APPROVED);
        }
    }
}
