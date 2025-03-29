package com.madebywizard.ecommerce.user.services;


import com.madebywizard.ecommerce.Command;
import com.madebywizard.ecommerce.exceptions.ErrorMessages;
import com.madebywizard.ecommerce.exceptions.UserNotValidException;
import com.madebywizard.ecommerce.user.UserRepository;
import com.madebywizard.ecommerce.user.model.User;
import com.madebywizard.ecommerce.user.model.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateUserService implements Command<User, String> {

    private final PasswordEncoder encoder;

    private final UserRepository userRepository;

    public CreateUserService(PasswordEncoder encoder, UserRepository userRepository) {
        this.encoder = encoder;
        this.userRepository = userRepository;
    }


    public ResponseEntity<String> execute(User user) {
//        UserValidator.validate(user);

        // Optional<User> optionalUser = userRepository.findByUserId(user.getUserId());

        // check if user id already exists
        if (userRepository.findByUserId(user.getUserId()).isPresent()) {
            throw new UserNotValidException(ErrorMessages.USER_ID_ALREADY_EXIST.getMessage());
        }

        // check if user email already exists
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserNotValidException(ErrorMessages.USER_EMAIL_ALREADY_EXIST.getMessage());
        }

        // encode the raw password
        user.setUserPassword(encoder.encode(user.getUserPassword()));
        User savedUser = userRepository.save(user);
        System.out.println(savedUser);
        return ResponseEntity.ok("SUCCESSFULLY CREATED! YOUR ID IS: " + savedUser.getUserId());

    }
}
