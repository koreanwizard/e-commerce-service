package com.madebywizard.ecommerce.user.services;

import com.madebywizard.ecommerce.Command;
import com.madebywizard.ecommerce.user.UserRepository;
import com.madebywizard.ecommerce.user.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteUserService implements Command<Integer, Void> { // temporarily, input is void and output is string

    private final UserRepository userRepository;

    public DeleteUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public ResponseEntity<Void> execute(Integer id) {

        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        /*
        an exception handler will be added in here
        */

        return null;
    }
}
