package com.spring.rentACar.controllers;

import com.spring.rentACar.services.abstracts.CustomerService;
import com.spring.rentACar.services.dtos.requests.customer.AddCustomerRequest;
import com.spring.rentACar.services.dtos.requests.customer.UpdateCustomerRequest;
import com.spring.rentACar.services.dtos.responses.customer.GetCustomerListResponse;
import com.spring.rentACar.services.dtos.responses.customer.GetCustomerResponse;
import com.spring.rentACar.entities.Customer;
import com.spring.rentACar.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/customers")
@AllArgsConstructor
public class CustomersController {

    private final CustomerService customerService;

    @GetMapping
    public List<GetCustomerListResponse> getAll(){
        return customerService.getAll();
    }

    @GetMapping("{id}")
    public GetCustomerResponse getById(@PathVariable int id){
        return customerService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddCustomerRequest addCustomerRequest){
        customerService.add(addCustomerRequest);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateCustomerRequest updateCustomerRequest){
        customerService.update(id, updateCustomerRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        customerService.delete(id);
    }
}
