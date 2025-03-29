package com.madebywizard.ecommerce.customer.services;

import com.madebywizard.ecommerce.Query;
import com.madebywizard.ecommerce.customer.CustomerRepository;
import com.madebywizard.ecommerce.customer.model.Customer;
import com.madebywizard.ecommerce.customer.model.CustomerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCustomersService implements Query<Void, List<CustomerDTO>> {

    private final CustomerRepository customerRepository;

    public GetCustomersService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public ResponseEntity<List<CustomerDTO>> execute(Void input) {

        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> customerDTOS = customers.stream().map(CustomerDTO::new).toList();
        return ResponseEntity.status(HttpStatus.OK).body(customerDTOS);
    }
}
