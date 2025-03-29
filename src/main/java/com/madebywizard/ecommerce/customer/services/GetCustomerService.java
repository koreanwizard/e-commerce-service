package com.madebywizard.ecommerce.customer.services;

import com.madebywizard.ecommerce.Query;
import com.madebywizard.ecommerce.exceptions.ErrorMessages;
import com.madebywizard.ecommerce.exceptions.UserNotFoundException;
import com.madebywizard.ecommerce.customer.UserRepository;
import com.madebywizard.ecommerce.customer.model.Customer;
import com.madebywizard.ecommerce.customer.model.CustomerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetUserService implements Query<Integer, CustomerDTO> { // Input: user id, Output: UserDTO

    private final UserRepository userRepository;

    public GetUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<CustomerDTO> execute(Integer input) {
        Optional<Customer> userOptional = userRepository.findById(input);
        if (userOptional.isPresent()) {
            return ResponseEntity.ok(new CustomerDTO(userOptional.get()));
        }

        throw new UserNotFoundException(ErrorMessages.USER_NOT_FOUND.getMessage());
    }
}
