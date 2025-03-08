package com.madebywizard.ecommerce.exceptions;

public enum ErrorMessages {
    USER_NOT_FOUND("User Not Found"),
    ELEMENT_REQUIRED("this is a required element"),
    ALPHABETIC_REQUIRED("should be alphabetic"),
    ONLY_M_OR_F_REQUIRED("should be one of the character: M / F"),
    BIRTHDATE_FORMAT_REQUIRED("check your birth date format (YYYY-MM-DD)"),
    USER_ID_AND_PASSWORD_LENGTH("length should be greater than 3");

    // add additional error messages into this enum list
    // it helps us to manage every error message in one place

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
