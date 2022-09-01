package com.revarute.marketplace.beans.controllers;

import com.revarute.marketplace.beans.services.CustomerService;
import com.revarute.marketplace.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/customers")
public class CustomerController {

    private CustomerService service;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.service = customerService;
    }

    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody Customer getCustomerById(@PathVariable Integer customerId) {
        Optional<Customer> optionalCustomer = service.getCustomerById(customerId);
        //TODO: Do the isPresent() check and throw exception if needed
        return optionalCustomer.get();
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void createCustomer(@RequestBody Customer customer) {
        service.createCustomer(customer);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void updateCustomer(@RequestBody Customer customer) {
        service.updateCustomer(customer);
    }

    @RequestMapping(value = "/{customerId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteCustomer(@PathVariable(name = "customerId") Integer id) {
        service.deleteById(id);
    }
}
