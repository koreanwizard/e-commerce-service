package com.madebywizard.ecommerce.user;

import com.madebywizard.ecommerce.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetUserService implements Query<Void, String> { // temporarily, input is void and output is string

    @Override
    public ResponseEntity<String> execute(Void input) {
        return ResponseEntity.status(HttpStatus.OK).body("get user");
    }
}
