package com.spring.rentACar.controllers;

import com.spring.rentACar.services.abstracts.AddressService;
import com.spring.rentACar.services.dtos.requests.address.AddAddressRequest;
import com.spring.rentACar.services.dtos.requests.address.UpdateAddressRequest;
import com.spring.rentACar.services.dtos.responses.address.GetAddressListResponse;
import com.spring.rentACar.services.dtos.responses.address.GetAddressResponse;
import com.spring.rentACar.entities.Address;
import com.spring.rentACar.repositories.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/addresses")
@AllArgsConstructor
public class AddressesController {

    private final AddressService addressService;


    @GetMapping
    public List<GetAddressListResponse> getAll(){
        return addressService.getAll();
    }

    @GetMapping("{id}")
    public GetAddressResponse getById(@PathVariable int id){
        return addressService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddAddressRequest addAddressRequest){
        addressService.add(addAddressRequest);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateAddressRequest updateAddressRequest){
        addressService.update(id, updateAddressRequest);

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        addressService.delete(id);
    }

}
