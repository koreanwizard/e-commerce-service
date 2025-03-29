package com.madebywizard.ecommerce.customer;

import com.madebywizard.ecommerce.customer.model.Customer;
import com.madebywizard.ecommerce.customer.services.CreateCustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    private final CreateCustomerService createCustomerService;

    public CustomerController(CreateCustomerService createCustomerService) {
        this.createCustomerService = createCustomerService;
    }


    // will return a string if successfully created
    @PostMapping("/user")
    public ResponseEntity<String> createSingleUser(@RequestBody Customer customer) {
        return createCustomerService.execute(customer);
    }










//    @PreAuthorize("hasRole('admin')")
//    @GetMapping("/users")
//    public ResponseEntity<List<UserDTO>> getEveryUser() {
//        return getUsersService.execute(null);
//    }

//    @GetMapping("/users/{id}")
//    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Integer id) {
//        return getUserService.execute(id);
//    }

}
