package com.madebywizard.ecommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomerNotValidException extends RuntimeException {
    public CustomerNotValidException(String message) {
        super(message);
    }
}
