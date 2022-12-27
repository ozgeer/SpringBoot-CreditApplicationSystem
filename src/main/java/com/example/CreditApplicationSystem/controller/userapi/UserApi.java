package com.example.CreditApplicationSystem.controller.userapi;

import com.example.CreditApplicationSystem.dto.client.UserCreateDTO;
import com.example.CreditApplicationSystem.dto.client.UserUpdateDTO;
import com.example.CreditApplicationSystem.dto.client.UserViewDTO;
import com.example.CreditApplicationSystem.dto.credit.CreditApplyDTO;
import com.example.CreditApplicationSystem.services.client.UserService;
import com.example.CreditApplicationSystem.services.credit.CreditService;
import com.example.CreditApplicationSystem.shared.GenericResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/user")
@Tag(name="CLIENT OPERATIONS")
public class UserApi {
    private final UserService userService;
    private final CreditService creditService;

//    @GetMapping("/user/{id}")
//    public BigDecimal getScore(@PathVariable Long id){
//       final BigDecimal score=userService.getCreditScoreCalculate(id);
//        return score;
//    }

    @GetMapping("/get-client-list")
    @Operation(summary= "Returns all client")
    public ResponseEntity<List<UserViewDTO>> getClientList(){
    final List<UserViewDTO> clientList=userService.getClientList();
     return ResponseEntity.ok(clientList);
    }

    @PostMapping("/register")
    @Operation(summary = "Creates new account")
    public ResponseEntity<UserViewDTO> createClient(@RequestBody UserCreateDTO userCreateDTO){
        final UserViewDTO client=userService.createClient(userCreateDTO);
        return ResponseEntity.ok(client);
    }

    @PutMapping("/{id}")
    @Operation(summary ="Updates the account information")
    public ResponseEntity<UserViewDTO> updateClient(@PathVariable("id") Long Id,@RequestBody UserUpdateDTO userUpdateDTO){
        final UserViewDTO client=userService.updateClient(Id,userUpdateDTO);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deactives the account")
    public ResponseEntity<UserViewDTO> deleteClient(@PathVariable("id") Long Id){
        final UserViewDTO client=userService.deleteClient(Id);
        return ResponseEntity.ok(client);

    }

    @PostMapping ("/credit-apply")
    @Operation(summary = "Saves the loan application in the database")
    public ResponseEntity<?> applyCredit(@RequestBody CreditApplyDTO creditApplyDTO){
        creditService.creditApply(creditApplyDTO);
        return ResponseEntity.ok(new GenericResponse("Your application has been received"));
    }

    @GetMapping("credit-apply-response")
    @Operation(summary = "Returns result of loan application")
    public List<UserViewDTO> creditResult(Long id){
        creditService.creditApplyResponse(id);
        return null;
    }


}
