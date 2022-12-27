package com.example.CreditApplicationSystem.constants.creditlimitvariable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum IncomeAbove10000 {
    depositmultiple(0.25);
    private double value;

}
