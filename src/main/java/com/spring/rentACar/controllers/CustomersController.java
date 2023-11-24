package com.spring.rentACar.controllers;

import com.spring.rentACar.dtos.requests.customer.AddCustomerRequest;
import com.spring.rentACar.dtos.requests.customer.UpdateCustomerRequest;
import com.spring.rentACar.dtos.responses.customer.GetCustomerListResponse;
import com.spring.rentACar.dtos.responses.customer.GetCustomerResponse;
import com.spring.rentACar.entities.Customer;
import com.spring.rentACar.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomersController {

    private final CustomerRepository customerRepository;

    public CustomersController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<GetCustomerListResponse> getAll(){
        List<Customer> customers = customerRepository.findAll();
        List<GetCustomerListResponse> getCustomerListResponses = new ArrayList<>();
        for (Customer customer : customers){
            GetCustomerListResponse getCustomerListResponse = new GetCustomerListResponse();
            getCustomerListResponse.setAge(customer.getAge());
            getCustomerListResponse.setName(customer.getName());
            getCustomerListResponse.setSurname(customer.getSurname());
            getCustomerListResponses.add(getCustomerListResponse);
        }
        return getCustomerListResponses;
    }

    @GetMapping("{id}")
    public GetCustomerResponse getById(@PathVariable int id){
        Customer customer = customerRepository.findById(id).orElseThrow();
        GetCustomerResponse getCustomerResponse = new GetCustomerResponse();
        getCustomerResponse.setAge(customer.getAge());
        getCustomerResponse.setName(customer.getName());
        getCustomerResponse.setSurname(customer.getSurname());
        getCustomerResponse.setEmail(customer.getEmail());
        return getCustomerResponse;
    }

    @PostMapping
    public void add(@RequestBody AddCustomerRequest addCustomerRequest){
        Customer customer = new Customer();
        customer.setAge(addCustomerRequest.getAge());
        customer.setName(addCustomerRequest.getName());
        customer.setEmail(addCustomerRequest.getEmail());
        customer.setSurname(addCustomerRequest.getSurname());
        customer.setTcNo(addCustomerRequest.getTcNo());
        customer.setGender(addCustomerRequest.getGender());
        customerRepository.save(customer);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateCustomerRequest updateCustomerRequest){
        Customer customerToUpdate = customerRepository.findById(id).orElseThrow();
            customerToUpdate.setAge(updateCustomerRequest.getAge());
            customerToUpdate.setEmail(updateCustomerRequest.getEmail());
            customerToUpdate.setName(updateCustomerRequest.getName());
            customerToUpdate.setSurname(updateCustomerRequest.getSurname());
            customerToUpdate.setTcNo(updateCustomerRequest.getTcNo());
            customerToUpdate.setGender(updateCustomerRequest.getGender());
        customerRepository.save(customerToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        customerRepository.deleteById(id);
    }
}
