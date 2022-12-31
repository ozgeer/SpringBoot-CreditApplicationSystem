package com.example.CreditApplicationSystem.services.givencredit;

import com.example.CreditApplicationSystem.dto.credit.CreditApplyResponseDTO;

public class GivenCreditScoreBelowOneThousand implements GivenCreditType {
    @Override
    public CreditApplyResponseDTO getCreditLimit(Double income, Double deposit) {
        return null;
    }
}
