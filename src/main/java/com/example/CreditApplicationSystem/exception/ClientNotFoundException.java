package com.example.CreditApplicationSystem.exception;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(Integer id) {
        super("Could not find employee " + id);
    }
}