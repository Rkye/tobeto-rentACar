package com.spring.rentACar.controllers;

import com.spring.rentACar.entities.Address;
import com.spring.rentACar.repositories.AddressRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/addresses")
public class AddressesController {

    private final AddressRepository addressRepository;

    public AddressesController(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    @GetMapping
    public List<Address> getAll(){
        return addressRepository.findAll();
    }

    @GetMapping("{id}")
    public Address getById(@PathVariable int id){
        return addressRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Address address){
        addressRepository.save(address);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id,@RequestBody Address address){
        Address addressToUpdate = addressRepository.findById(id).orElseThrow();
            addressToUpdate.setAddressText(address.getAddressText());
            addressToUpdate.setCity(address.getCity());
            addressToUpdate.setBills(address.getBills());
            addressToUpdate.setCounty(address.getCounty());
            addressToUpdate.setCustomer(address.getCustomer());
            addressToUpdate.setPostalCode(address.getPostalCode());
        addressRepository.save(addressToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        addressRepository.deleteById(id);
    }

}
