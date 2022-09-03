package com.revature.MKPG.beans.Controllers;

import com.revature.MKPG.beans.Services.ItemService;
import com.revature.MKPG.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/items")
public class ItemController {
    private ItemService service;

    @Autowired
    public ItemController(ItemService itemService){
        this.service = itemService;
    }

    @GetMapping("/{itemId}")
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody Item getItemById(@PathVariable Integer itemId) {
        Optional<Item> optionalUser = service.getItemById(itemId);
        try{
            optionalUser.isPresent();
        }catch(Exception e){
            System.out.println(e);
        }
        return optionalUser.get();
    }

    @GetMapping()
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<Item> getAllItems() {
        return service.getAllItems();
    }

    @PostMapping()
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void createItem(@Valid @RequestBody Item item){
        service.createItem(item);
    }

    @PutMapping()
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void updateItem(@Valid @RequestBody Item item){
        service.updateItem(item);
    }

    @DeleteMapping()
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteItem(@PathVariable Integer itemId) {
        Optional<Item> optionalUser = service.getItemById(itemId);
        try{
            optionalUser.isPresent();
        }catch(Exception e){
            System.out.println(e);
        }
       service.deleteItemById(itemId);
    }
}
