package com.example.CreditApplicationSystem.services.credit;
import com.example.CreditApplicationSystem.dto.credit.CreditApplyDTO;
import com.example.CreditApplicationSystem.dto.credit.CreditApplyResponseDTO;
import com.example.CreditApplicationSystem.repository.CreditRepository;
import com.example.CreditApplicationSystem.services.client.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreditServiceImp implements CreditService {

    private final CreditRepository creditRepository;
    private UserServiceImp userServiceImp;

    @Override
    public CreditApplyResponseDTO creditApply(CreditApplyDTO creditApplyDTO) {
        return null;
    }


}
