package com.revature.MKPG.beans.Controllers;

import com.revature.MKPG.beans.Services.ItemService;
import com.revature.MKPG.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/items")
public class ItemController {
    private ItemService service;

    @Autowired
    public ItemController(ItemService itemService){
        this.service = itemService;
    }

    @RequestMapping(value = "/{itemId}", method = RequestMethod.GET)
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

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<Item> getAllItems() {
        return service.getAllItems();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void createItem(@RequestBody Item item){
        service.createItem(item);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void updateItem(@RequestBody Item item){
        service.updateItem(item);
    }

    @RequestMapping(value = "/{itemId}", method = RequestMethod.DELETE)
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
