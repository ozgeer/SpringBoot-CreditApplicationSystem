package com.example.CreditApplicationSystem.services;

import com.example.CreditApplicationSystem.dto.UserCreateDTO;
import com.example.CreditApplicationSystem.dto.UserUpdateDTO;
import com.example.CreditApplicationSystem.dto.UserViewDTO;

import java.util.List;

public interface UserService {
//    BigDecimal getCreditScoreCalculate(@PathVariable Long citizenId);
    UserViewDTO createUser(UserCreateDTO userCreateDTO);
    UserViewDTO updateUser(UserUpdateDTO userUpdateDTO);
    List<UserViewDTO> getClientList();
}
