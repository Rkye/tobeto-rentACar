package com.spring.rentACar.services.dtos.responses.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCustomerResponse {
    private String name;
    private String surname;
    private  int age;
    private String email;
}
