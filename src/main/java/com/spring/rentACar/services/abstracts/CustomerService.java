package com.spring.rentACar.services.abstracts;

import com.spring.rentACar.services.dtos.requests.customer.AddCustomerRequest;
import com.spring.rentACar.services.dtos.requests.customer.UpdateCustomerRequest;
import com.spring.rentACar.services.dtos.responses.customer.GetCustomerListResponse;
import com.spring.rentACar.services.dtos.responses.customer.GetCustomerResponse;

import java.util.List;

public interface CustomerService {
    void add(AddCustomerRequest addCustomerRequest);
    GetCustomerResponse getById(int id);
    List<GetCustomerListResponse> getAll();
    void update(int id, UpdateCustomerRequest updateCustomerRequest);
    void delete(int id);
    List<GetCustomerListResponse> getByAgeLessThan(int age);
    List<GetCustomerListResponse> getByAgeOrderBySurnameDesc(int age);
    List<GetCustomerListResponse> getByCustomerGreaterThanAge(int age);
    GetCustomerResponse getByIdJPQL(int id);
}
