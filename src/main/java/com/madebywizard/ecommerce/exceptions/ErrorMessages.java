package com.madebywizard.ecommerce.exceptions;

public enum ErrorMessages {
    ITEM_NOT_FOUND("Item Not Found"),
    ELEMENT_REQUIRED("this is a required element"),
    INVALID_TYPE("invalid type"),
    INVALID_SIZE("invalid size"),
    INVALID_ITEM_NAME("invalid item name"),
    INVALID_ITEM_COLOR("invalid color name"),
    INVALID_REMAINING_ITEM("the number of remaining item cannot be negative"),
    INVALID_ENUM("invalid enum");

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
