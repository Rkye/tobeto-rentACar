package com.spring.rentACar.services.dtos.requests.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomerRequest {
    private String name;
    private String surname;
    private  int age;
    private String tcNo;
    private char gender;
    private String email;
}
