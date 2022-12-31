package com.example.CreditApplicationSystem.services.givencredit;

import com.example.CreditApplicationSystem.dto.credit.CreditApplyResponseDTO;

public class GivenCreditIncomeBelowTenThousand implements GivenCreditType {
    @Override
    public CreditApplyResponseDTO getCreditLimit(Double deposit, Double income) {
        return null;
    }
}
