package com.revature.MKPG.beans.Repositories;

import com.revature.MKPG.entities.Address;
import com.revature.MKPG.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{
}