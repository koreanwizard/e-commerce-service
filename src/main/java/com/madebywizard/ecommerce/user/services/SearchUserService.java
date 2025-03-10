package com.madebywizard.ecommerce.user.services;

import com.madebywizard.ecommerce.Query;
import com.madebywizard.ecommerce.user.UserRepository;
import com.madebywizard.ecommerce.user.model.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchUserService implements Query<String, List<UserDTO>> {

    private final UserRepository userRepository;

    public SearchUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<List<UserDTO>> execute(String lastName) {
        return ResponseEntity.ok(userRepository.findByLastNameContaining(lastName)
                .stream()
                .map(UserDTO::new)
                .toList());
    }
}
