package com.example.CreditApplicationSystem.services.credit;
import com.example.CreditApplicationSystem.dto.credit.CreditApplyDTO;
import com.example.CreditApplicationSystem.dto.credit.CreditApplyResponseDTO;
import com.example.CreditApplicationSystem.entities.Client;
import com.example.CreditApplicationSystem.entities.Credit;
import com.example.CreditApplicationSystem.repository.CreditRepository;
import com.example.CreditApplicationSystem.services.client.UserServiceImp;
import com.example.CreditApplicationSystem.services.givencredit.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CreditServiceImp implements CreditService {

    private final CreditRepository creditRepository;
    private final UserServiceImp userServiceImp;

    public static Integer getCreditScoreCalculate(String citizenId){
        Integer score=(int) (Math.random()*1500);
        return Integer.valueOf(score);
    }

    @Override
    public void creditApply(CreditApplyDTO creditApplyDTO) {
        Credit credit= new Credit();
        credit.setClient(creditApplyDTO.getClient());
        credit.setIncome(creditApplyDTO.getIncome());
        credit.setDeposit(creditApplyDTO.getDeposit());
        credit.setCreditScore(CreditServiceImp.getCreditScoreCalculate(creditApplyDTO.getClient().getCitizenId()));
        creditRepository.save(credit);
    }

    public CreditApplyResponseDTO creditApplyEvaluation(String citizenId) {
        Client client=userServiceImp.findCustomerByIdentityNo(citizenId);
        Credit credit=creditRepository.findCreditByClient(client);

        Double deposit = credit.getDeposit();
        Double income=credit.getIncome();
        Integer creditScore=credit.getCreditScore();

        CreditApplyResponseDTO response=getCreditLimit(client,creditScore,income,deposit);
        return response;

    }

    public CreditApplyResponseDTO getCreditLimit(Client client, Integer creditScore, Double income, Double deposit){
      Type type=new  Type();
      if(creditScore<500){
        type.setGivenCreditType(new CreditScoreBelowFiveHundred());
      }
      else if(creditScore>=500 && creditScore<1000 ){
          if(income<5000) {
              type.setGivenCreditType(new GivenCreditScoreBelowOneThousand());
          }
          else if(income>=5000 && income<10000){
              type.setGivenCreditType(new GivenCreditIncomeBelowTenThousand());
          }
          else{
              type.setGivenCreditType(new GivenCreditIncomeAboveTenThousand());
          }
      }
      else {
          type.setGivenCreditType(new GivenCreditScoreAboveOneThousand());
      }
        return type.getGivenCreditLimit(income,deposit);
    }

    public Credit findCreditByClient(Client client){
        return creditRepository.findCreditByClient(client);
    }



}
