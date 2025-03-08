package com.madebywizard.ecommerce.user;


import com.madebywizard.ecommerce.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // spring data jpa
    List<User> findByLastNameContaining(String lastName);

    // we can also use JPQL to create a customized query but in this project we will just use the Jpa.


}
