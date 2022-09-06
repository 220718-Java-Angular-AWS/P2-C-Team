package com.revature.DaynaJonesP2.beans.repositories;

import com.revature.DaynaJonesP2.Entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Cart extends JpaRepository<Cart, Integer> {
            /*
    Extending the CrudRepository (by way of JpaRepository) should implement the following CRUD operations for us:
    save()
    saveAll()
    findById()
    existsById()
    findAll()
    findAllById()
    count()
    deleteById()
    delete()
    deleteAll()
     */

    Optional<Cart> findByCustomer(String Customer);

}