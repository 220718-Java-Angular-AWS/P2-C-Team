package com.revature.MKPG.beans.Repositories;

import com.revature.MKPG.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
