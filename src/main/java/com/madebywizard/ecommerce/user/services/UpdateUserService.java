package com.madebywizard.ecommerce.user.services;

import com.madebywizard.ecommerce.Command;
import com.madebywizard.ecommerce.exceptions.UserNotFoundException;
import com.madebywizard.ecommerce.user.UserRepository;
import com.madebywizard.ecommerce.user.model.UpdateUserCommand;
import com.madebywizard.ecommerce.user.model.User;
import com.madebywizard.ecommerce.user.model.UserDTO;
import com.madebywizard.ecommerce.user.validators.UserValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateUserService implements Command<UpdateUserCommand, UserDTO> { // input an UpdatUserCommand object and output UserDTO obj


    private final UserRepository userRepository;

    public UpdateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public ResponseEntity<UserDTO> execute(UpdateUserCommand command) {
        /*
        validate new user's information by using 'UserValidator' 'execute' method by passing current user object
        'save' JpaRepository method saves but also updates the data
         */

        Optional<User> userOptional = userRepository.findById(command.getId());
        if (userOptional.isPresent()) {
            User user = command.getUser();
            user.setId(command.getId());

            UserValidator.execute(user); // validator

            userRepository.save(user);
            return ResponseEntity.ok(new UserDTO(user));
        }

        throw new UserNotFoundException();
    }
}
