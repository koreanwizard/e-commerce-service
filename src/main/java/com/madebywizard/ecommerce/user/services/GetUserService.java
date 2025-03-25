package com.madebywizard.ecommerce.user.services;

import com.madebywizard.ecommerce.Query;
import com.madebywizard.ecommerce.exceptions.UserNotFoundException;
import com.madebywizard.ecommerce.user.UserRepository;
import com.madebywizard.ecommerce.user.model.User;
import com.madebywizard.ecommerce.user.model.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetUserService implements Query<Integer, UserDTO> { // Input: user id, Output: UserDTO

    private final UserRepository userRepository;

    public GetUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<UserDTO> execute(Integer input) {
        Optional<User> userOptional = userRepository.findById(input);
        if (userOptional.isPresent()) {
            return ResponseEntity.ok(new UserDTO(userOptional.get()));
        }

        throw new UserNotFoundException();
    }
}
