package com.revature.Celectronics.beans.Repositories;

import com.revature.Celectronics.entities.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepo extends JpaRepository<Items, Integer> {

}
