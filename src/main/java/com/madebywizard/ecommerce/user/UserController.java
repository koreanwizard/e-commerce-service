package com.madebywizard.ecommerce.user;


// import org.springframework.beans.factory.annotation.Autowired;
// org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;




@RestController
public class UserController {

    private final CreateUserService createUserService;

    private final GetUserService getUserService;

    private final UpdateUserService updateUserService;

    private final DeleteUserService deleteUserService;


    public UserController(CreateUserService createUserService,
                          GetUserService getUserService,
                          UpdateUserService updateUserService,
                          DeleteUserService deleteUserService) {

        this.createUserService = createUserService;
        this.getUserService = getUserService;
        this.updateUserService = updateUserService;
        this.deleteUserService = deleteUserService;
    }


    @PostMapping
    public ResponseEntity<String> createUser() {
        return createUserService.execute(null);
    }

    @GetMapping
    public ResponseEntity<String> getUser() {
        return getUserService.execute(null);
    }

    @PutMapping
    public ResponseEntity<String> updateUser() {
        return updateUserService.execute(null);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser() {
        return deleteUserService.execute(null);
    }

}
