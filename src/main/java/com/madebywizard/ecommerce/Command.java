package com.madebywizard.ecommerce;

import org.springframework.http.ResponseEntity;

public interface Command <I, O>{
    /*
    - I: input, O: output
    - forces to implement the 'execute' method by using @Override
    - guarantees the 'execute' method includes consistency from this application.
    - will be used for CREATE, PUT, and DELETE requests

    Command: modifies the data -> suitable for CREATE, PUT, and DELETE requests that possibly change data.
     */
    ResponseEntity<O> execute(I input);
}
