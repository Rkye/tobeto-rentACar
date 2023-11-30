package com.spring.rentACar.services.dtos.requests.county;

import com.spring.rentACar.entities.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCountyRequest {
    private City city;
    private String name;
}
