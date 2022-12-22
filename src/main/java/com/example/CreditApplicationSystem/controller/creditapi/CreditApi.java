package com.example.CreditApplicationSystem.controller.creditapi;

import com.example.CreditApplicationSystem.services.credit.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/credit")
public class CreditApi {
    private final CreditService creditService;
}
