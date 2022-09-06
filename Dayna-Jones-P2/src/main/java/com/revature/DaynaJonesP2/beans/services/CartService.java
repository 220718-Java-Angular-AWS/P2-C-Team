package com.revature.DaynaJonesP2.beans.services;

import com.revature.DaynaJonesP2.beans.repositories.CartRepository;
import com.revature.DaynaJonesP2.Entities.Cart;
import com.revature.DaynaJonesP2.Exceptions.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    CartRepository repo;
    ValidatorService validator;

    @Autowired
    public CartService(CartRepository CartRepository, ValidatorService validatorService) {
        this.repo = CartRepository;
        this.validator = validatorService;
    }

    //5 crud things:
    // GET - read - find,
    // GET - read all - find all,
    // POST - create - save,
    // PUT/PATCH - update - save,
    // DELETE - delete - delete

    public List<Cart> getAllCart() {
        return repo.findAll();
    }

    public Optional<Cart> getCartById(Integer id) {
        return repo.findById(id);
    }

    public void createCart(Cart cart) throws InvalidInputException {
        if(validator.validateCart(cart)) {
            repo.save(cart);
        } else {
            throw new InvalidInputException("this user has invalid data");
        }
    }

    public void updateCart(Cart cart) {
        repo.save(cart);
    }

    public void deleteById(Integer id) {
        repo.deleteById(id);
    }


}