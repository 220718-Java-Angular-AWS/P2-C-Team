package com.revature.MKPG.beans.services;

import com.revature.MKPG.Entities.Cart;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class ValidatorService {

    public boolean validateUser(Cart cart) {
        boolean valid = true;

        //validate user email:
        if (cart.getEmail() == null || !Pattern.matches("^[A-Za-z0-9\\.\\-_]+@[A-Za-z0-9\\-]+\\.[A-Za-z]{2,5}$", user.getEmail())) {
            valid = false;
        }
        if(cart.getFirstName() == null || !Pattern.matches("^[A-Za-z' -\\.]{1,25}$", user.getFirstName())) {
            valid = false;
        }
        if(cart.getLastName() == null || !Pattern.matches("^[A-Za-z' -\\.]{1,25}$", user.getFirstName())) {
            valid = false;
        }

        return valid;

    }

}