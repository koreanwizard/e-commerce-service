package com.madebywizard.ecommerce.user.services;

import com.madebywizard.ecommerce.Command;
import com.madebywizard.ecommerce.user.UserRepository;
import com.madebywizard.ecommerce.user.model.UpdateUserCommand;
import com.madebywizard.ecommerce.user.model.User;
import com.madebywizard.ecommerce.user.model.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateUserService implements Command<UpdateUserCommand, UserDTO> { // temporarily, input is void and output is string


    private final UserRepository userRepository;

    public UpdateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public ResponseEntity<UserDTO> execute(UpdateUserCommand command) {

        Optional<User> userOptional = userRepository.findById(command.getId());
        if (userOptional.isPresent()) {
            User user = command.getUser();
            user.setId(command.getId());
            userRepository.save(user);
            return ResponseEntity.ok(new UserDTO(user));
        }

        /*
        an exception handler will be added in here
        */

        return null;
    }
}
