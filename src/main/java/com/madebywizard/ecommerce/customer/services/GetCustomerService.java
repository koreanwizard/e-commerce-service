package com.madebywizard.ecommerce.customer.services;

import com.madebywizard.ecommerce.Query;
import com.madebywizard.ecommerce.exceptions.ErrorMessages;
import com.madebywizard.ecommerce.exceptions.CustomerNotFoundException;
import com.madebywizard.ecommerce.customer.CustomerRepository;
import com.madebywizard.ecommerce.customer.model.Customer;
import com.madebywizard.ecommerce.customer.model.CustomerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetCustomerService implements Query<Integer, CustomerDTO> { // Input: user id, Output: UserDTO

    private final CustomerRepository customerRepository;

    public GetCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public ResponseEntity<CustomerDTO> execute(Integer input) {
        Optional<Customer> userOptional = customerRepository.findById(input);
        if (userOptional.isPresent()) {
            return ResponseEntity.ok(new CustomerDTO(userOptional.get()));
        }

        throw new CustomerNotFoundException(ErrorMessages.CUSTOMER_NOT_FOUND.getMessage());
    }
}
