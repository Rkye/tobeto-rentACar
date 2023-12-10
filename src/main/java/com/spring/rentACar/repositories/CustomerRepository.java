package com.spring.rentACar.repositories;

import com.spring.rentACar.entities.Customer;
import com.spring.rentACar.services.dtos.responses.customer.GetCustomerListResponse;
import com.spring.rentACar.services.dtos.responses.customer.GetCustomerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    // Derived Query Method - 1
    List<Customer> findByAgeLessThan(int age);

    // Derived Query Method - 2
    List<Customer> findByAgeOrderBySurnameDesc(int age);

    // JPQL - 1
    @Query("Select new com.spring.rentACar.services.dtos.responses.customer.GetCustomerListResponse(c.name, c.surname, c.age)" +
            " from Customer c where c.age >= :age")
    List<GetCustomerListResponse> getByCustomerGreaterThanAge(int age);

    // JPQL - 2
    @Query("Select new com.spring.rentACar.services.dtos.responses.customer" +
            ".GetCustomerResponse(c.name, c.surname, c.age, c.email)" +
            " from Customer c where c.id = :id")
    GetCustomerResponse getByIdJPQL(int id);
}
