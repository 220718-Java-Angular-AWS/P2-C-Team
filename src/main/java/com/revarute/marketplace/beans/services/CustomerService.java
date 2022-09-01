package com.revarute.marketplace.beans.services;

import com.revarute.marketplace.beans.repositories.CustomerRepo;
import com.revarute.marketplace.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    CustomerRepo repo;

    @Autowired
    public CustomerService(CustomerRepo repo) {
        this.repo = repo;
    }

    public List<Customer> getAllCustomers() {
        return repo.findAll();
    }

    public Optional<Customer> getCustomerById(Integer id) {
        return repo.findById(id);
    }

    public void createCustomer(Customer customer) {
        repo.save(customer);
    }

    public void updateCustomer(Customer customer) {
        repo.save(customer);
    }

    public void deleteById(Integer id) {
        repo.deleteById(id);
    }
}
