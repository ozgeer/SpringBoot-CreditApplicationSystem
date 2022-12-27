package com.example.CreditApplicationSystem.services.client;

import com.example.CreditApplicationSystem.dto.client.UserCreateDTO;
import com.example.CreditApplicationSystem.dto.client.UserUpdateDTO;
import com.example.CreditApplicationSystem.dto.client.UserViewDTO;
import com.example.CreditApplicationSystem.entities.Client;

import java.util.List;

public interface UserService {
    UserViewDTO createClient(UserCreateDTO userCreateDTO);
    UserViewDTO updateClient(Long Id,UserUpdateDTO userUpdateDTO);
    UserViewDTO deleteClient(Long Id);
    List<UserViewDTO> getClientList();
}
