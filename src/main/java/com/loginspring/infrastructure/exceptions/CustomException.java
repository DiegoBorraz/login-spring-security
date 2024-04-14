package com.loginspring.infrastructure.exceptions;

public class CustomException extends RuntimeException {

    public CustomException(String message) {
        super(message);
    }
}
