package com.example.CreditApplicationSystem.services.credit;

import com.example.CreditApplicationSystem.dto.client.UserCreateDTO;
import com.example.CreditApplicationSystem.dto.credit.CreditApplyDTO;
import com.example.CreditApplicationSystem.dto.credit.CreditApplyResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditService {
    CreditApplyResponseDTO creditApply(CreditApplyDTO creditApplyDTO);

}
