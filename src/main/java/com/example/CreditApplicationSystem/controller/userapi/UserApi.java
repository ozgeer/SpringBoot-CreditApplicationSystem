package com.example.CreditApplicationSystem.controller.userapi;

import com.example.CreditApplicationSystem.dto.client.UserCreateDTO;
import com.example.CreditApplicationSystem.dto.client.UserUpdateDTO;
import com.example.CreditApplicationSystem.dto.client.UserViewDTO;
import com.example.CreditApplicationSystem.dto.credit.CreditApplyDTO;
import com.example.CreditApplicationSystem.dto.credit.CreditApplyResponseDTO;
import com.example.CreditApplicationSystem.services.client.UserService;
import com.example.CreditApplicationSystem.services.credit.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserApi {

    private final UserService userService;
    private final CreditService creditService;

//    @GetMapping("/user/{id}")
//    public BigDecimal getScore(@PathVariable Long id){
//       final BigDecimal score=userService.getCreditScoreCalculate(id);
//        return score;
//    }

    @GetMapping("/clientList")
    public ResponseEntity<List<UserViewDTO>> getClientList(){
    final List<UserViewDTO> clientList=userService.getClientList();
     return ResponseEntity.ok(clientList);
    }

    @PostMapping("/create")
//    @ApiOperation()
    public ResponseEntity<UserViewDTO> createClient(@RequestBody UserCreateDTO userCreateDTO){
        final UserViewDTO client=userService.createClient(userCreateDTO);
        return ResponseEntity.ok(client);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserViewDTO> updateClient(@PathVariable("id") Integer Id,@RequestBody UserUpdateDTO userUpdateDTO){
        final UserViewDTO client=userService.updateClient(Id,userUpdateDTO);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserViewDTO> deleteClient(@PathVariable("id") Integer Id){
        final UserViewDTO client=userService.deleteClient(Id);
        return ResponseEntity.ok(client);

    }

    @PostMapping ("/credit_apply")
    public ResponseEntity<CreditApplyResponseDTO> applyCredit(@RequestBody CreditApplyDTO creditApplyDTO){
        final CreditApplyResponseDTO response=creditService.creditApply(creditApplyDTO);
        return ResponseEntity.ok(response);
    }

}
