package com.revature.MKPG.beans.Repositories;

import com.revature.MKPG.entities.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepo extends MyRepoBase<Item, Integer> {

    @Query("FROM Item i WHERE i.itemName LIKE :itemName")
    Optional<List<Item>> findBySimilarTitle(@Param("itemName") String itemName);
}
