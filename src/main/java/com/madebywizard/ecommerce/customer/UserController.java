package com.madebywizard.ecommerce.user;

import com.madebywizard.ecommerce.user.model.User;
import com.madebywizard.ecommerce.user.model.UserDTO;
import com.madebywizard.ecommerce.user.services.CreateUserService;
import com.madebywizard.ecommerce.user.services.GetUserService;
import com.madebywizard.ecommerce.user.services.GetUsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final CreateUserService createUserService;

    public UserController(CreateUserService createUserService) {
        this.createUserService = createUserService;
    }


    // will return a string if successfully created
    @PostMapping("/user")
    public ResponseEntity<String> createSingleUser(@RequestBody User user) {
        return createUserService.execute(user);
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
