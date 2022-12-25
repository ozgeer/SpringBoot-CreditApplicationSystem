package com.example.CreditApplicationSystem.shared;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data //bu sadece default cons. üretiyor.
public final class GenericResponse {
    private String message;
}
