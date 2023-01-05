package com.example.CreditApplicationSystem.services.givencredit;

import com.example.CreditApplicationSystem.dto.credit.CreditApplyResponseDTO;
import com.example.CreditApplicationSystem.entities.Client;

public class Type {
    private GivenCreditType givenCreditType;

    public void setGivenCreditType(GivenCreditType givenCreditType){
        this.givenCreditType=givenCreditType;
    }

    public CreditApplyResponseDTO getGivenCreditLimit(Client client, Double income, Double deposit){
       return givenCreditType.getCreditLimit(client,income,deposit);
    }


}
