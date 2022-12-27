package com.example.CreditApplicationSystem.constants.creditlimitvariable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CreditScoreAboveOneThousand {
    depositmultiple(0.5);
    private double value;
}
