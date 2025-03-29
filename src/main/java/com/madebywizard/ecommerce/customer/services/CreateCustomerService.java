package com.madebywizard.ecommerce.customer.services;


import com.madebywizard.ecommerce.Command;
import com.madebywizard.ecommerce.customer.model.Customer;
import com.madebywizard.ecommerce.exceptions.ErrorMessages;
import com.madebywizard.ecommerce.exceptions.UserNotValidException;
import com.madebywizard.ecommerce.customer.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService implements Command<Customer, String> {

    private final PasswordEncoder encoder;

    private final UserRepository userRepository;

    public CreateUserService(PasswordEncoder encoder, UserRepository userRepository) {
        this.encoder = encoder;
        this.userRepository = userRepository;
    }


    public ResponseEntity<String> execute(Customer customer) {
//        UserValidator.validate(user);

        // Optional<User> optionalUser = userRepository.findByUserId(user.getUserId());

        // check if user id already exists
        if (userRepository.findByUserId(customer.getUserId()).isPresent()) {
            throw new UserNotValidException(ErrorMessages.USER_ID_ALREADY_EXIST.getMessage());
        }

        // check if user email already exists
        if (userRepository.findByEmail(customer.getEmail()).isPresent()) {
            throw new UserNotValidException(ErrorMessages.USER_EMAIL_ALREADY_EXIST.getMessage());
        }

        // encode the raw password
        customer.setUserPassword(encoder.encode(customer.getUserPassword()));
        Customer savedCustomer = userRepository.save(customer);
        System.out.println(savedCustomer);
        return ResponseEntity.ok("SUCCESSFULLY CREATED! YOUR ID IS: " + savedCustomer.getUserId());

    }
}
