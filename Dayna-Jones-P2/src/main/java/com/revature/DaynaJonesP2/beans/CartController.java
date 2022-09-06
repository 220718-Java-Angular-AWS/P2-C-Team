package com.revature.DaynaJonesP2.beans;

import com.revature.DaynaJonesP2.beans.services.CartService;
import com.revature.DaynaJonesP2.Entities.Cart;
import com.revature.DaynaJonesP2.Exceptions.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/Cart")
public class CartController {
    private CartService service;

    @Autowired
    public CartController(CartService cartService) {
        this.service = cartService;
    }



    //5 crud things:
    // GET - read - find,
    // GET - read all - find all,
    // POST - create - save,
    // PUT/PATCH - update - save,
    // DELETE - delete - delete

    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody Cart getCartById(@PathVariable Integer cartId) {
        Optional<Cart> optionalCart = service.getCartById(cartId);
        //TODO: Do the isPresent() check and throw exception if needed
        return optionalCart.get();
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<Cart> getAllCart() {
        return service.getAllCart();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void createCart(@RequestBody Cart cart) throws InvalidInputException {
        service.createCart(cart);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void updateCart(@RequestBody Cart cart) {
        service.updateCart(cart);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteCart(@PathVariable(name = "cartId") Integer id) {
        service.deleteById(id);
    }

}