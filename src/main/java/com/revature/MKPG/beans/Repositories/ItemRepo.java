package com.revature.MKPG.beans.Repositories;

import com.revature.MKPG.entities.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepo extends MyRepoBase<Item, Integer> {

    @Query("SELECT i FROM Item i WHERE i.item_name =:item_name")
    Optional<Item> findBySimilarItemName(
            @Param("item_name") String itemName);

    @Query("SELECT i FROM Item i WHERE i.price = :price")
    Optional<List<Item>> findAllByPrice(
            @Param("price") Double price);
}