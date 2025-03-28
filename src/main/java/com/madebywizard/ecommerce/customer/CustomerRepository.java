package com.madebywizard.ecommerce.customer;

import com.madebywizard.ecommerce.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByCustomerId(String userId);
    Optional<Customer> findByEmail(String email);

}
