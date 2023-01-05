package com.example.CreditApplicationSystem.services.givencredit;

import com.example.CreditApplicationSystem.dto.credit.CreditApplyResponseDTO;
import com.example.CreditApplicationSystem.entities.Client;

public interface GivenCreditType {
    CreditApplyResponseDTO getCreditLimit(Client client, Double income, Double deposit);
}
