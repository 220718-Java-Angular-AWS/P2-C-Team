package com.revature.ProjectTwo.beans.repositories;

import com.revature.ProjectTwo.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{
}
