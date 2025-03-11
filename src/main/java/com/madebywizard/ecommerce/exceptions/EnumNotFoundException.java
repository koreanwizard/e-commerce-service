package com.madebywizard.ecommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EnumNotFoundException extends IllegalArgumentException {
    public EnumNotFoundException() {
        super(ErrorMessages.INVALID_ENUM.getMessage());
    }
}
