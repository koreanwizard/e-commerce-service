package com.madebywizard.ecommerce.item.model;

// a record class for error response (ErrorResponse is immutable and only requires a getter method to get message)
public record ErrorResponse (String message){
}