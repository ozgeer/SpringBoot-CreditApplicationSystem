package com.example.CreditApplicationSystem.services.givencredit;
import com.example.CreditApplicationSystem.dto.credit.CreditApplyResponseDTO;

import java.util.logging.*;

public class CreditScoreBelowFiveHundred implements GivenCreditType {
    @Override
    public CreditApplyResponseDTO getCreditLimit(Double income, Double deposit) {
        return null;
    }
}
