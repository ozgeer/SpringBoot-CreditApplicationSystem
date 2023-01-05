package com.example.CreditApplicationSystem.services.credit;

import com.example.CreditApplicationSystem.dto.credit.CreditApplyDTO;
import com.example.CreditApplicationSystem.dto.credit.CreditApplyResponseDTO;

public interface CreditService {
    void creditApply(CreditApplyDTO creditApplyDTO);
    CreditApplyResponseDTO creditApplyEvaluation(String citizenId);


}
