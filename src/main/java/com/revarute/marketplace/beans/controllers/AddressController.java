package com.revarute.marketplace.beans.controllers;

import com.revarute.marketplace.beans.services.AddressService;
import com.revarute.marketplace.entities.Address;
import com.revarute.marketplace.exceptions.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/address")
public class AddressController {
    private AddressService service;

    @Autowired
    public AddressController(AddressService addressService) {
        this.service = addressService;
    }

    @GetMapping( "/{addressId}")
    @ResponseStatus(value = HttpStatus.OK)
    public Address getAddressById(@PathVariable Integer addressId) throws CustomerNotFoundException {
        Optional<Address> optionalAddress = service.getAddressById(addressId);

        Address address = null;

        if (optionalAddress.isPresent()) {
            address = optionalAddress.get();
        } else {
            throw new CustomerNotFoundException("Did not find Address id - " + addressId);
        }

        return address;
    }

    @GetMapping()
    @ResponseStatus(value = HttpStatus.OK)
    public List<Address> getAllAddress() {
        return service.getAllAddress();
    }

    @PostMapping()
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public Address createAddress(@RequestBody Address address) {
        service.createAddress(address);
        return address;
    }

    @PutMapping()
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public Address updateAddress(@RequestBody Address address) {
        service.createAddress(address);
        return address;
    }

    @DeleteMapping("/{addressId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteAddress(@PathVariable(name = "addressId") Integer id) {
        service.deleteById(id);
    }
}
