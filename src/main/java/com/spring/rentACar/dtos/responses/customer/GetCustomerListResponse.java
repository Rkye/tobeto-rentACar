package com.spring.rentACar.dtos.responses.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCustomerListResponse {
    private String name;
    private String surname;
    private  int age;

}
