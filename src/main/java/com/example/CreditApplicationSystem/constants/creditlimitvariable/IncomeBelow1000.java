package com.example.CreditApplicationSystem.constants.creditlimitvariable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum IncomeBelow1000 {
    depositmultiple(0.1);
    private double value;

}
