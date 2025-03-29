package com.madebywizard.ecommerce.customer.services;

import com.madebywizard.ecommerce.Query;
import com.madebywizard.ecommerce.customer.UserRepository;
import com.madebywizard.ecommerce.customer.model.Customer;
import com.madebywizard.ecommerce.customer.model.CustomerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUsersService implements Query<Void, List<CustomerDTO>> {

    private final UserRepository userRepository;

    public GetUsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<List<CustomerDTO>> execute(Void input) {

        List<Customer> customers = userRepository.findAll();
        List<CustomerDTO> customerDTOS = customers.stream().map(CustomerDTO::new).toList();
        return ResponseEntity.status(HttpStatus.OK).body(customerDTOS);
    }
}
