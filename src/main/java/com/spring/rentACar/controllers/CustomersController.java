package com.spring.rentACar.controllers;

import com.spring.rentACar.entities.Customer;
import com.spring.rentACar.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomersController {

    private final CustomerRepository customerRepository;

    public CustomersController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    @GetMapping("{id}")
    public Customer getById(@PathVariable int id){
        return customerRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Customer customer){
        customerRepository.save(customer);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Customer customer){
        Customer customerToUpdate = customerRepository.findById(id).orElseThrow();
            customerToUpdate.setAddresses(customer.getAddresses());
            customerToUpdate.setAge(customer.getAge());
            customerToUpdate.setEmail(customer.getEmail());
            customerToUpdate.setName(customer.getName());
            customerToUpdate.setSurname(customer.getSurname());
            customerToUpdate.setTcNo(customer.getTcNo());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        customerRepository.deleteById(id);
    }
}
