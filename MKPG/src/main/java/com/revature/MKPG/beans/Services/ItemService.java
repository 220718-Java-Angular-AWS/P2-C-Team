package com.revature.MKPG.beans.Services;

import com.revature.MKPG.beans.Repositories.ItemRepo;
import com.revature.MKPG.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    ItemRepo repo;

    @Autowired
    public ItemService(ItemRepo itemRepo){
        this.repo = itemRepo;
    }

    public List<Item> getAllItems(){
        return repo.findAll();
    }

    public Optional<Item> getItemById(Integer id){
        return repo.findById(id);
    }

    public Optional<Item> getItemByName(String itemName){
        return repo.getItemByName(itemName);
    }

    public void createItem(Item item){
        repo.save(item);
    }

    public void updateItem(Item item){
        repo.save(item);
    }

    public void deleteItemById(Integer id){
        repo.deleteById(id);
    }
}
