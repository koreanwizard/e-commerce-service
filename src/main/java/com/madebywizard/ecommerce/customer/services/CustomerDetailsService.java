package com.madebywizard.ecommerce.customer.services;


import com.madebywizard.ecommerce.customer.CustomerRepository;
import com.madebywizard.ecommerce.customer.model.Customer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomerDetailsService implements UserDetailsService{

    private final CustomerRepository customerRepository;

    public CustomerDetailsService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }




    @Override
    public UserDetails loadUserByUsername(String customerId) throws UsernameNotFoundException {

        Customer customer = customerRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new UsernameNotFoundException("user name not found from UserDetailsService class"));

        // a location where add roles and authorities to the user
        // relational mapping can also be added here to get roles and authorities



        return User
                .withUsername(customer.getCustomerId())
                .authorities("BASIC")
                .roles("CUSTOMER")
                .password(customer.getCustomerPassword())
                .build();
    }
}
