package com.example.CreditApplicationSystem.services.credit;
import com.example.CreditApplicationSystem.dto.credit.CreditApplyDTO;
import com.example.CreditApplicationSystem.dto.credit.CreditApplyResponseDTO;
import com.example.CreditApplicationSystem.entities.Credit;
import com.example.CreditApplicationSystem.repository.CreditRepository;
import com.example.CreditApplicationSystem.services.client.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreditServiceImp implements CreditService {

    private final CreditRepository creditRepository;

    @Override
    public CreditApplyResponseDTO creditApply(CreditApplyDTO creditApplyDTO) {
        Credit credit= new Credit();
        credit.setClient(creditApplyDTO.getClient());
        credit.setIncome(creditApplyDTO.getIncome());
        credit.setDeposit(creditApplyDTO.getDeposit());
        creditRepository.save(credit);
        return null;
    }


}
