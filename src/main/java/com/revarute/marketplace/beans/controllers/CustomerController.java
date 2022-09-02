package com.revarute.marketplace.beans.controllers;

import com.revarute.marketplace.beans.services.CustomerService;
import com.revarute.marketplace.entities.Customer;
import com.revarute.marketplace.exceptions.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    private CustomerService service;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.service = customerService;
    }

    @GetMapping( "/{customerId}")
    @ResponseStatus(value = HttpStatus.OK)
    public Customer getCustomerById(@PathVariable Integer customerId) throws CustomerNotFoundException {
        Optional<Customer> optionalCustomer = service.getCustomerById(customerId);

        Customer customer = null;

        if (optionalCustomer.isPresent()) {
            customer = optionalCustomer.get();
        } else {
            throw new CustomerNotFoundException("Did not find customer id - " + customerId);
        }

        return customer;
    }

    @GetMapping()
    @ResponseStatus(value = HttpStatus.OK)
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    @PostMapping()
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public Customer createCustomer(@Valid @RequestBody Customer customer) {
        service.createCustomer(customer);
        return customer;
    }

    @PutMapping()
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public Customer updateCustomer(@RequestBody Customer customer) {
        service.updateCustomer(customer);
        return customer;
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteCustomer(@PathVariable(name = "customerId") Integer id) {
        service.deleteById(id);
    }
}
