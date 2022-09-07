package com.revature.MKPG.beans.Controllers;

import com.revature.MKPG.beans.Services.CartService;
import com.revature.MKPG.beans.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

}
