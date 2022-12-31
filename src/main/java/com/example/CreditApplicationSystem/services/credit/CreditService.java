package com.example.CreditApplicationSystem.services.credit;

import com.example.CreditApplicationSystem.dto.client.UserCreateDTO;
import com.example.CreditApplicationSystem.dto.client.UserViewDTO;
import com.example.CreditApplicationSystem.dto.credit.CreditApplyDTO;
import com.example.CreditApplicationSystem.dto.credit.CreditApplyResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CreditService {
    void creditApply(CreditApplyDTO creditApplyDTO);
    CreditApplyResponseDTO creditApplyEvaluation(String citizenId);


}
