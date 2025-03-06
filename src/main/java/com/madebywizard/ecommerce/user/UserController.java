package com.madebywizard.ecommerce.user;


 import com.madebywizard.ecommerce.user.model.UpdateUserCommand;
 import com.madebywizard.ecommerce.user.services.*;
import com.madebywizard.ecommerce.user.model.User;
import com.madebywizard.ecommerce.user.model.UserDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
public class UserController {

    private final CreateUserService createUserService;

    private final GetUsersService getUsersService;

    private final GetUserService getUserService;

    private final UpdateUserService updateUserService;

    private final DeleteUserService deleteUserService;


    public UserController(CreateUserService createUserService,
                          GetUsersService getUsersService,
                          GetUserService getUserService,
                          UpdateUserService updateUserService,
                          DeleteUserService deleteUserService) {

        this.createUserService = createUserService;
        this.getUsersService = getUsersService;
        this.getUserService = getUserService;
        this.updateUserService = updateUserService;
        this.deleteUserService = deleteUserService;
    }


    @PostMapping("/user")
    public ResponseEntity<UserDTO> createUser(@RequestBody User user) {
        return createUserService.execute(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUsers() {
        return getUsersService.execute(null);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Integer id) {
        return getUserService.execute(id);
    }


    @PutMapping("/user/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {

        // passing both id and 'User' object
        return updateUserService.execute(new UpdateUserCommand(id, user));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
        return deleteUserService.execute(id);
    }

}
