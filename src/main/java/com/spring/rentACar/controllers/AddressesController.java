package com.spring.rentACar.controllers;

import com.spring.rentACar.dtos.requests.address.AddAddressRequest;
import com.spring.rentACar.dtos.requests.address.UpdateAddressRequest;
import com.spring.rentACar.dtos.responses.address.GetAddressListResponse;
import com.spring.rentACar.dtos.responses.address.GetAddressResponse;
import com.spring.rentACar.entities.Address;
import com.spring.rentACar.repositories.AddressRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/addresses")
public class AddressesController {

    private final AddressRepository addressRepository;

    public AddressesController(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    @GetMapping
    public List<GetAddressListResponse> getAll(){
        List<Address> Addresses= addressRepository.findAll();
        List<GetAddressListResponse> getAddressListResponses = new ArrayList<>();
        for (Address address:Addresses) {
            GetAddressListResponse getAddressListResponse = new GetAddressListResponse();
            getAddressListResponse.setAddressText(address.getAddressText());
            getAddressListResponse.setPostalCode(address.getPostalCode());
            getAddressListResponses.add(getAddressListResponse);
        }
        return getAddressListResponses;
    }

    @GetMapping("{id}")
    public GetAddressResponse getById(@PathVariable int id){
        Address address = addressRepository.findById(id).orElseThrow();
        GetAddressResponse getAddressResponse = new GetAddressResponse();
        getAddressResponse.setAddressText(address.getAddressText());
        getAddressResponse.setPostalCode(address.getPostalCode());
        getAddressResponse.setCountyName(address.getCounty().getName());
        getAddressResponse.setCityName(address.getCounty().getCity().getName());
        return getAddressResponse;
    }

    @PostMapping
    public void add(@RequestBody AddAddressRequest addAddressRequest){
        Address address = new Address();
        address.setPostalCode(addAddressRequest.getPostalCode());
        address.setAddressText(addAddressRequest.getAddressText());
        address.setCounty(addAddressRequest.getCounty());
        addressRepository.save(address);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateAddressRequest updateAddressRequest){
        Address addressToUpdate = addressRepository.findById(id).orElseThrow();
            addressToUpdate.setAddressText(updateAddressRequest.getAddressText());
            addressToUpdate.setPostalCode(updateAddressRequest.getPostalCode());
            addressToUpdate.setCounty(updateAddressRequest.getCounty());
        addressRepository.save(addressToUpdate);

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        addressRepository.deleteById(id);
    }

}
