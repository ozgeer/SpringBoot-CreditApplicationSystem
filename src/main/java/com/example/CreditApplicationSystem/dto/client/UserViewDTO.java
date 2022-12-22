package com.example.CreditApplicationSystem.dto.client;

import com.example.CreditApplicationSystem.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
@Getter
@AllArgsConstructor
public class UserViewDTO implements Serializable {
    private String name;
    private String lastName;
    private Long citizenId;
//    private String result;
//    private Integer limit;

    public static UserViewDTO of(Client client){
        return new UserViewDTO (client.getName(),client.getLastName(),client.getCitizenId());
    }




}
