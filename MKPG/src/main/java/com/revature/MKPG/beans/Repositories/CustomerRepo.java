package com.revature.MKPG.beans.Repositories;

import com.revature.MKPG.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByEmail(String email);
}
