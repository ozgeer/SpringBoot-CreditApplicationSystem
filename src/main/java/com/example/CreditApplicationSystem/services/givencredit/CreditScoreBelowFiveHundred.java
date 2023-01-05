package com.example.CreditApplicationSystem.services.givencredit;
import com.example.CreditApplicationSystem.constants.Response;
import com.example.CreditApplicationSystem.dto.credit.CreditApplyResponseDTO;
import com.example.CreditApplicationSystem.entities.Client;

import java.math.BigDecimal;


public class CreditScoreBelowFiveHundred implements GivenCreditType {
    @Override
    public CreditApplyResponseDTO getCreditLimit(Client client,Double income, Double deposit) {
        System.out.println("Your credit score is not convenient.");
        Double creditLimit= Double.valueOf(0);
        return new CreditApplyResponseDTO(client,creditLimit, Response.DENIED);
    }
}
