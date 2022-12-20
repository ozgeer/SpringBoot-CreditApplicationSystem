package com.example.CreditApplicationSystem.controller;

import com.example.CreditApplicationSystem.dto.UserCreateDTO;
import com.example.CreditApplicationSystem.dto.UserViewDTO;
import com.example.CreditApplicationSystem.entities.Client;
import com.example.CreditApplicationSystem.services.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class UserApi {

    private final UserService userService;

//    @GetMapping("/user/{id}")
//    public BigDecimal getScore(@PathVariable Long id){
//       final BigDecimal score=userService.getCreditScoreCalculate(id);
//        return score;
//    }

    @GetMapping("/user/clientList")
    public ResponseEntity<List<UserViewDTO>> getClientList(){
    final List<UserViewDTO> clientList=userService.getClientList();
     return ResponseEntity.ok(clientList);
    }

    @PostMapping("/user/create")
    public ResponseEntity<UserViewDTO> createUser(@RequestBody UserCreateDTO userCreateDTO){
        final UserViewDTO user=userService.createUser(userCreateDTO);
        return ResponseEntity.ok(user);
    }




}
