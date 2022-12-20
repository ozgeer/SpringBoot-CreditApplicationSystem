package com.example.CreditApplicationSystem.services;

import com.example.CreditApplicationSystem.dto.UserCreateDTO;
import com.example.CreditApplicationSystem.dto.UserUpdateDTO;
import com.example.CreditApplicationSystem.dto.UserViewDTO;
import com.example.CreditApplicationSystem.entities.Client;
import com.example.CreditApplicationSystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;


    public static Integer getCreditScoreCalculate(Long citizenId){
        Integer score=(int) (Math.random()*1500);
        return Integer.valueOf(score);
    }

    @Override
    public UserViewDTO createUser(UserCreateDTO userCreateDTO) {
        final Client client=new Client();
        client.setCitizenId(userCreateDTO.getCitizenId());
        client.setName(userCreateDTO.getName());
        client.setLastName(userCreateDTO.getLastname());
        client.setPhoneNumber(userCreateDTO.getPhoneNumber());
        client.setIncome(userCreateDTO.getIncome());
        client.setDeposit(userCreateDTO.getDeposit());
        client.setBirthDate(userCreateDTO.getBirthDate());
        client.setCreditScore(UserServiceImp.getCreditScoreCalculate(userCreateDTO.getCitizenId()));
        userRepository.save(client);
        return UserViewDTO.of(client);
    }

    @Override
    public UserViewDTO updateUser(UserUpdateDTO userUpdateDTO) {
        return null;
    }

    @Override
    public List<UserViewDTO> getClientList() {
       return userRepository.findAll().stream().filter(x->x.isActive()==true).map(UserViewDTO::of).collect(Collectors.toList());
    }


}
