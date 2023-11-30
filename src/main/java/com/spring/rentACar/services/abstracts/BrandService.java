package com.spring.rentACar.services.abstracts;

import com.spring.rentACar.services.dtos.requests.brand.AddBrandRequest;
import com.spring.rentACar.services.dtos.requests.brand.UpdateBrandRequest;
import com.spring.rentACar.services.dtos.responses.brand.GetBrandListResponse;
import com.spring.rentACar.services.dtos.responses.brand.GetBrandResponse;

import java.util.List;

public interface BrandService {
    void add(AddBrandRequest addBrandRequest);
    GetBrandResponse getById(int id);
    List<GetBrandListResponse> getAll();
    void update(int id, UpdateBrandRequest updateBrandRequest);
    void delete(int id);

}
