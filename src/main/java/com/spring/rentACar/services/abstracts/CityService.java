package com.spring.rentACar.services.abstracts;

import com.spring.rentACar.services.dtos.requests.city.AddCityRequest;
import com.spring.rentACar.services.dtos.requests.city.UpdateCityRequest;
import com.spring.rentACar.services.dtos.responses.city.GetCityListResponse;
import com.spring.rentACar.services.dtos.responses.city.GetCityResponse;

import java.util.List;

public interface CityService {
    void add(AddCityRequest addCityRequest);
    GetCityResponse getById(int id);
    List<GetCityListResponse> getAll();
    void update(int id, UpdateCityRequest updateCityRequest);
    void delete(int id);
    List<GetCityListResponse> getByNameStartingWith(String prefix);
    List<GetCityListResponse> getByNameNotNull();
    List<GetCityListResponse> getByNameEndsWith(String name);
    List<GetCityListResponse> getNameLengthGreaterThan(int length);
}
