package com.madebywizard.ecommerce.customer.services;


import com.madebywizard.ecommerce.Command;
import com.madebywizard.ecommerce.customer.model.Customer;
import com.madebywizard.ecommerce.exceptions.ErrorMessages;
import com.madebywizard.ecommerce.exceptions.CustomerNotValidException;
import com.madebywizard.ecommerce.customer.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateCustomerService implements Command<Customer, String> {

    private final PasswordEncoder encoder;

    private final CustomerRepository customerRepository;

    public CreateCustomerService(PasswordEncoder encoder, CustomerRepository customerRepository) {
        this.encoder = encoder;
        this.customerRepository = customerRepository;
    }


    public ResponseEntity<String> execute(Customer customer) {
        // CustomerValidator.validate(user);

        // THESE SHOULD BE INSIDE CustomerValidator.validate METHOD!!!
        // check if customer id already exists
        if (customerRepository.findByCustomerId(customer.getCustomerId()).isPresent()) {
            throw new CustomerNotValidException(ErrorMessages.CUSTOMER_ID_ALREADY_EXIST.getMessage());
        }

        // check if user email already exists
        if (customerRepository.findByEmail(customer.getEmail()).isPresent()) {
            throw new CustomerNotValidException(ErrorMessages.CUSTOMER_EMAIL_ALREADY_EXIST.getMessage());
        }

        // encode the raw password, save it to the repository, and returns a string message to congrate a new customer
        customer.setCustomerPassword(encoder.encode(customer.getCustomerPassword()));
        customerRepository.save(customer);
        System.out.println(customer);
        return ResponseEntity.ok("CONGRATULATION! SUCCESSFULLY CREATED! YOUR ID IS: " + customer.getCustomerId());
    }
}
