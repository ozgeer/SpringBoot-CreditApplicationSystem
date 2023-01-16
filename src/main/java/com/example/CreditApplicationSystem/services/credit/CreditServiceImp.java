package com.example.CreditApplicationSystem.services.credit;
import com.example.CreditApplicationSystem.constants.Response;
import com.example.CreditApplicationSystem.dto.credit.CreditApplyDTO;
import com.example.CreditApplicationSystem.dto.credit.CreditApplyResponseDTO;
import com.example.CreditApplicationSystem.entities.ApprovedCredit;
import com.example.CreditApplicationSystem.entities.Client;
import com.example.CreditApplicationSystem.entities.Credit;
import com.example.CreditApplicationSystem.repository.ApprovedCreditRepository;
import com.example.CreditApplicationSystem.repository.CreditRepository;
import com.example.CreditApplicationSystem.services.client.UserService;
import com.example.CreditApplicationSystem.services.givencredit.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
@Service
@RequiredArgsConstructor
@Controller
public class CreditServiceImp implements CreditService {

    private final CreditRepository creditRepository;
    private final UserService userService;
    private final ApprovedCreditRepository approvedCreditRepository;

    public static Integer getCreditScoreCalculate(String citizenId) {
        Integer score = (int) (Math.random() * 1500);
        return Integer.valueOf(score);
    }

    @Override
    public void creditApply(CreditApplyDTO creditApplyDTO) {
        Credit credit = new Credit();
        credit.setClient(creditApplyDTO.getClient());
        credit.setIncome(creditApplyDTO.getIncome());
        credit.setDeposit(creditApplyDTO.getDeposit());
        credit.setCreditScore(CreditServiceImp.getCreditScoreCalculate(creditApplyDTO.getClient().getCitizenId()));
        creditRepository.save(credit);
    }

    public CreditApplyResponseDTO creditApplyEvaluation(@RequestBody String citizenId) {
        Client client = userService.findCustomerByIdentityNo(citizenId);
        Credit credit = creditRepository.findCreditByClient(client);

        Double deposit = credit.getDeposit();
        Double income = credit.getIncome();
        Integer creditScore = credit.getCreditScore();

        CreditApplyResponseDTO response = getCreditLimit(client, creditScore, income, deposit);
        updateCreditTable(response);
        return response;
    }

    public CreditApplyResponseDTO getCreditLimit(Client client, Integer creditScore, Double income, Double deposit) {
        Type type = new Type();
        if (creditScore < 500) {
            type.setGivenCreditType(new CreditScoreBelowFiveHundred());
        } else if (creditScore >= 500 && creditScore < 1000) {
            if (income < 5000) {
                type.setGivenCreditType(new GivenCreditScoreBelowOneThousand());
            } else if (income >= 5000 && income < 10000) {
                type.setGivenCreditType(new GivenCreditIncomeBelowTenThousand());
            } else {
                type.setGivenCreditType(new GivenCreditIncomeAboveTenThousand());
            }
        } else {
            type.setGivenCreditType(new GivenCreditScoreAboveOneThousand());
        }
        return type.getGivenCreditLimit(client,income, deposit);
    }

    public Credit findCreditByClient(Client client) {
        return creditRepository.findCreditByClient(client);
    }

    public void updateCreditTable(CreditApplyResponseDTO creditApplyResponseDTO) {
        if (creditApplyResponseDTO.getCreditStatus() == Response.APPROVED) {
            ApprovedCredit approvedCredit = new ApprovedCredit();
            Credit credit=findCreditByClient(creditApplyResponseDTO.getClient());
            approvedCredit.setClient(creditApplyResponseDTO.getClient());
            approvedCredit.setCredit(credit);
            approvedCredit.setDeposit(credit.getDeposit());
            approvedCredit.setIncome(credit.getIncome());
            approvedCredit.setCreditScore(credit.getCreditScore());
            approvedCredit.setCreditStatus(creditApplyResponseDTO.getCreditStatus());
            approvedCredit.setCreditLimit(creditApplyResponseDTO.getCreditLimit());

            credit.setCreditLimit(creditApplyResponseDTO.getCreditLimit());
            credit.setCreditStatus(creditApplyResponseDTO.getCreditStatus());
            approvedCreditRepository.save(approvedCredit);
            creditRepository.save(credit);

        }
        else{
        Credit credit = findCreditByClient(creditApplyResponseDTO.getClient());
        credit.setCreditStatus(creditApplyResponseDTO.getCreditStatus());
        credit.setCreditLimit(creditApplyResponseDTO.getCreditLimit());
        creditRepository.save(credit);
    }
}
}


