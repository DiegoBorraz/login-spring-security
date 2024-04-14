package com.loginspring.core.domain.customException;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RestErrorMessage {

    private final HttpStatus status;
    private final String exception;
    private final String message;

}