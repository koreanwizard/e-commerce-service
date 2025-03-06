package com.madebywizard.ecommerce.user.services;

import com.madebywizard.ecommerce.Command;
import com.madebywizard.ecommerce.user.UserRepository;
import com.madebywizard.ecommerce.user.model.User;
import com.madebywizard.ecommerce.user.model.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService implements Command<User, UserDTO> { // now the input is User and the output is the DTO


    private final UserRepository userRepository; // access of user's repository

    public CreateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<UserDTO> execute(User user) {
        /*
        call 'save' method which is the JpaRepository method,
        and pass the newly saved 'User' object into the new 'UserDTO' object
         */
        User savedUser = userRepository.save(user);
        System.out.println(savedUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserDTO(savedUser));
    }
}
