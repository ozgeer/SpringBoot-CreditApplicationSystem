package com.example.CreditApplicationSystem.constants.creditlimitvariable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Getter
public enum CreditScoreAbove1000 {
    depositmultiple(0.5);
    private double value;
}
