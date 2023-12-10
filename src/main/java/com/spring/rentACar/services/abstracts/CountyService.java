package com.spring.rentACar.services.abstracts;


import com.spring.rentACar.services.dtos.requests.county.AddCountyRequest;
import com.spring.rentACar.services.dtos.requests.county.UpdateCountyRequest;
import com.spring.rentACar.services.dtos.responses.county.GetCountyListResponse;
import com.spring.rentACar.services.dtos.responses.county.GetCountyResponse;

import java.util.List;

public interface CountyService {
    void add(AddCountyRequest addCountyRequest);
    GetCountyResponse getById(int id);
    List<GetCountyListResponse> getAll();
    void update(int id, UpdateCountyRequest updateCountyRequest);
    void delete(int id);
    List<GetCountyListResponse> getByNameNotLike(String name);
    List<GetCountyListResponse> getByName(String name);
    GetCountyResponse getByIdQuery(int id);
    List<GetCountyListResponse> getNameStartsWith(String name);
}
