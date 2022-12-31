package com.example.CreditApplicationSystem.services.givencredit;

import com.example.CreditApplicationSystem.dto.credit.CreditApplyResponseDTO;


public class Type {
    GivenCreditType givenCredit;
    private GivenCreditType givenCreditType;

    public void setGivenCreditType(GivenCreditType givenCreditType){
        this.givenCreditType=givenCreditType;
    }

    public CreditApplyResponseDTO getGivenCreditLimit(Double income,Double deposit){
       return givenCreditType.getCreditLimit(income,deposit);
    }


}
