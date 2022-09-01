package com.revarute.marketplace.beans.repositories;

import com.revarute.marketplace.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
