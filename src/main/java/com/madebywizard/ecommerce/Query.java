package com.madebywizard.ecommerce;

import org.springframework.http.ResponseEntity;


public interface Query <I, O> {
    /*
    - I: input, O: output
    - forces to implement the 'execute' method by using @Override
    - guarantees the 'execute' method includes consistency from this application.
    - will be only used for the GET request

    Query: get data without changing -> suitable for the GET request because it does not modify data; it only reads it
     */
    ResponseEntity<O> execute(I input);
}
