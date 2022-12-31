package com.example.CreditApplicationSystem.services.givencredit;

import com.example.CreditApplicationSystem.dto.credit.CreditApplyResponseDTO;

public interface GivenCreditType {
    CreditApplyResponseDTO getCreditLimit(Double income, Double deposit);
}
