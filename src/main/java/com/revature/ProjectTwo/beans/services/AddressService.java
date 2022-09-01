package com.revature.ProjectTwo.beans.services;

import com.revature.ProjectTwo.beans.repositories.AddressRepository;
import com.revature.ProjectTwo.entities.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    private AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAddresses(){
        return addressRepository.findAll();
    }

    public Optional<Address> getAddressById(Integer id){
        return addressRepository.findById(id);
    }

    public void createAddress(Address address){
        addressRepository.save(address);
    }

    public void updateAddress(Address address){
        addressRepository.save(address);
    }

    public void deleteById(Integer id){
        addressRepository.deleteById(id);
    }
}
