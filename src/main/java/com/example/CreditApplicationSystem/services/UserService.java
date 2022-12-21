package com.example.CreditApplicationSystem.services;

import com.example.CreditApplicationSystem.dto.UserCreateDTO;
import com.example.CreditApplicationSystem.dto.UserUpdateDTO;
import com.example.CreditApplicationSystem.dto.UserViewDTO;

import java.util.List;

public interface UserService {
    UserViewDTO createClient(UserCreateDTO userCreateDTO);
    UserViewDTO updateClient(Integer Id,UserUpdateDTO userUpdateDTO);
    UserViewDTO deleteClient(Integer Id);
    List<UserViewDTO> getClientList();
}
