package com.sapari.expenso.exception;

import org.springframework.http.HttpStatus;

public class ExpenseNotFoundException extends RuntimeException{
    public ExpenseNotFoundException(String message) {
        super(message);
    }
}
