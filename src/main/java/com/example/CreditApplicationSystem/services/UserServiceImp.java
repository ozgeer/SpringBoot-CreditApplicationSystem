package com.example.CreditApplicationSystem.services;

import com.example.CreditApplicationSystem.dto.UserCreateDTO;
import com.example.CreditApplicationSystem.dto.UserUpdateDTO;
import com.example.CreditApplicationSystem.dto.UserViewDTO;
import com.example.CreditApplicationSystem.entities.Client;
import com.example.CreditApplicationSystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;
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
    public UserViewDTO createClient(UserCreateDTO userCreateDTO) {
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

    /**yeni deger gelmisse alsın ama aksi halde oldugu gibi kalsın.su hali ile null atıyor.**/
    @Override
    public UserViewDTO updateClient(Integer Id,UserUpdateDTO userUpdateDTO) {
        final Client client=userRepository.findById(Id).orElseThrow(()-> new NotFoundException("there is no client"));
        client.setName(userUpdateDTO.getName());
        client.setLastName(userUpdateDTO.getLastName());
        client.setIncome(userUpdateDTO.getIncome());
        client.setDeposit(userUpdateDTO.getDeposit());
        client.setPhoneNumber(userUpdateDTO.getPhoneNumber());
        final Client updatedClient=userRepository.save(client);
        return UserViewDTO.of(updatedClient);
    }

    @Override
    public UserViewDTO deleteClient(Integer Id) {
        Client client = userRepository.findById(Id).orElseThrow(() -> new RuntimeException("there is no client"));
        // otomatik olarak isPresent i kontrol ediyor true ise get ile veriyi alıyor direk kasi halde exp fırlatıyor.
        client.setActive(false);
        userRepository.save(client);
//        Optional<Client> client = userRepository.findById(Id); // null pointer exc yememek için.
//        if(client.isPresent()){
//            client.get().setActive(false);
//            userRepository.save(client.get());
//        }
//
//        else{
//            throw new RuntimeException("there is no client");
//        }

        return UserViewDTO.of(client);
    }

    @Override
    public List<UserViewDTO> getClientList() {
       return userRepository.findAll().stream().filter(x->x.isActive()==true).map(UserViewDTO::of).collect(Collectors.toList());
    }


}
