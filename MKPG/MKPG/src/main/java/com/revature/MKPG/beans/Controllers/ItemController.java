package com.revature.MKPG.beans.Controllers;

import com.revature.MKPG.beans.Services.ItemService;
import com.revature.MKPG.entities.Item;
import com.revature.MKPG.exceptions.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/item")
public class ItemController{
    private ItemService service;

    @Autowired
    public ItemController(ItemService itemService){
        this.service = itemService;
    }

    @GetMapping("/{itemId}")
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody Item getItemById(@PathVariable Integer itemId) {
        Optional<Item> optionalItem = service.getItemById(itemId);

        Item item = null;

        if(optionalItem.isPresent()) {
            item = optionalItem.get();
        }else {
            throw new CustomerNotFoundException( "Item id " + itemId + " not found");
        }
        /*
        try{
            optionalUser.isPresent();
        }catch(Exception e){
            System.out.println(e);
        }*/
        return item;
    }

    @GetMapping("/{item_name}")
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody Item getItemByName(@PathVariable String itemName) {
        Optional<Item> optionalItem = service.findByName(itemName);

        Item item = null;

        if(optionalItem.isPresent()) {
            item = optionalItem.get();
        }else {
            throw new CustomerNotFoundException( "Item name " + itemName + " not found");
        }
       /* Optional<Item> optionalUser = service.findByName(itemName);
        try{
            optionalUser.isPresent();
        }catch(Exception e){
            System.out.println(e);
        }

        */
        return item;
    }

    @GetMapping("/all")
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
        Optional<Item> optionalItem = service.getItemById(itemId);

        Item item = null;

        if(optionalItem.isPresent()) {
            item = optionalItem.get();
        }else {
            throw new CustomerNotFoundException( "Item id " + itemId + " not found");
        }

        service.deleteItemById(item.getItemId());



        /*
        Optional<Item> optionalUser = service.getItemById(itemId);
        if(optionalUser.isPresent()){

        }else {
            System.out.println();
        }
       service.deleteItemById(itemId);

         */
    }
}
