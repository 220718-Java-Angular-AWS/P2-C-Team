package com.revarute.marketplace.beans.repositories;

import com.revarute.marketplace.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Integer> {
}
