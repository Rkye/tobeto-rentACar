package com.spring.rentACar.services.dtos.responses.county;

import com.spring.rentACar.entities.City;
import com.spring.rentACar.services.dtos.responses.city.GetCityResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCountyResponse {
    private String name;
    private GetCityResponse cityResponse;
}
