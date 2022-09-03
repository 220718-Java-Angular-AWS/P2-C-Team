package com.revarute.marketplace.beans.services;

import com.revarute.marketplace.beans.repositories.AddressRepo;
import com.revarute.marketplace.entities.Address;
import com.revarute.marketplace.entities.Customer;
import com.revarute.marketplace.exceptions.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    AddressRepo repo;
    CustomerService customerService;

    @Autowired
    public AddressService(AddressRepo repo, CustomerService customerService) {
        this.repo = repo;
        this.customerService = customerService;
    }

    public List<Address> getAllAddress() {
        return repo.findAll();
    }

    public Optional<Address> getAddressById(Integer id) {
        return repo.findById(id);
    }

    public void createAddress(Address address) {
        Optional<Customer> optionalCustomer = customerService.getCustomerById(address.getCustomer().getCustomerId());
        Customer customer = null;

        if (optionalCustomer.isPresent()) {
            customer = optionalCustomer.get();
            customer.addAddress(address);

        } else {
           // throw new CustomerNotFoundException("Did not find customer id - ");
        }
        repo.save(address);

    }

    public void updateAddress(Address address) {
        repo.save(address);
    }

    public void deleteById(Integer id) {
        repo.deleteById(id);
    }
}
