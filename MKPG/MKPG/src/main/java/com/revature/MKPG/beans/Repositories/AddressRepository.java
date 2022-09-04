package com.revature.eCommerce.beans.repositories;

import com.revature.eCommerce.entities.Address;
import com.revature.eCommerce.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{
}
