package com.example.CreditApplicationSystem.services.client;

import com.example.CreditApplicationSystem.dto.client.UserCreateDTO;
import com.example.CreditApplicationSystem.dto.client.UserUpdateDTO;
import com.example.CreditApplicationSystem.dto.client.UserViewDTO;

import java.util.List;

public interface UserService {
    UserViewDTO createClient(UserCreateDTO userCreateDTO);
    UserViewDTO updateClient(Integer Id,UserUpdateDTO userUpdateDTO);
    UserViewDTO deleteClient(Integer Id);
    List<UserViewDTO> getClientList();
}
