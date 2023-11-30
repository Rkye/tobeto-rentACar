package com.spring.rentACar.services.concretes;

import com.spring.rentACar.entities.Customer;
import com.spring.rentACar.repositories.CustomerRepository;
import com.spring.rentACar.services.abstracts.CustomerService;
import com.spring.rentACar.services.dtos.requests.customer.AddCustomerRequest;
import com.spring.rentACar.services.dtos.requests.customer.UpdateCustomerRequest;
import com.spring.rentACar.services.dtos.responses.customer.GetCustomerListResponse;
import com.spring.rentACar.services.dtos.responses.customer.GetCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {

    public CustomerRepository customerRepository;

    @Override
    public void add(AddCustomerRequest addCustomerRequest) {
        Customer customer = new Customer();
        customer.setAge(addCustomerRequest.getAge());
        customer.setName(addCustomerRequest.getName());
        customer.setEmail(addCustomerRequest.getEmail());
        customer.setSurname(addCustomerRequest.getSurname());
        customer.setTcNo(addCustomerRequest.getTcNo());
        customer.setGender(addCustomerRequest.getGender());
        customerRepository.save(customer);
    }

    @Override
    public GetCustomerResponse getById(int id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        GetCustomerResponse getCustomerResponse = new GetCustomerResponse();
        getCustomerResponse.setAge(customer.getAge());
        getCustomerResponse.setName(customer.getName());
        getCustomerResponse.setSurname(customer.getSurname());
        getCustomerResponse.setEmail(customer.getEmail());
        return getCustomerResponse;
    }

    @Override
    public List<GetCustomerListResponse> getAll() {
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

    @Override
    public void update(int id, UpdateCustomerRequest updateCustomerRequest) {
        Customer customerToUpdate = customerRepository.findById(id).orElseThrow();
        customerToUpdate.setAge(updateCustomerRequest.getAge());
        customerToUpdate.setEmail(updateCustomerRequest.getEmail());
        customerToUpdate.setName(updateCustomerRequest.getName());
        customerToUpdate.setSurname(updateCustomerRequest.getSurname());
        customerToUpdate.setTcNo(updateCustomerRequest.getTcNo());
        customerToUpdate.setGender(updateCustomerRequest.getGender());
        customerRepository.save(customerToUpdate);
    }

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);
    }
}
