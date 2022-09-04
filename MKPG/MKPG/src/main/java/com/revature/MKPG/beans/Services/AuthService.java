package com.revature.eCommerce.beans.services;

import com.revature.eCommerce.beans.repositories.CustomerRepository;
import com.revature.eCommerce.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.Optional;

@Service
public class AuthService {

    private CustomerRepository customerRepository;

    @Autowired
    public AuthService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer authenticate(String email, String password) throws AccessDeniedException{
        Optional<Customer> optionalCustomer = customerRepository.findByEmail(email);
        if(optionalCustomer.isPresent() && optionalCustomer.get().getPassword().equals(password)){
            return optionalCustomer.get();
        }else {
            throw new AccessDeniedException("Email or Password mismatch");
        }
    }

}
