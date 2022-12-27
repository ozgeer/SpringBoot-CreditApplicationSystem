package com.example.CreditApplicationSystem.constants.creditlimitvariable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum IncomeBelow10000 {
    depositmultiple(0.2);
    private double value;

}
