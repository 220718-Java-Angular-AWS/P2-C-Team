package com.revarute.marketplace.beans.services;

import com.revarute.marketplace.beans.repositories.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    AddressRepo repo;

    @Autowired
    public AddressService(AddressRepo repo) {
        this.repo = repo;
    }
}
