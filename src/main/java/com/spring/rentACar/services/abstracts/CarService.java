package com.spring.rentACar.services.abstracts;

import com.spring.rentACar.services.dtos.requests.car.AddCarRequest;
import com.spring.rentACar.services.dtos.requests.car.UpdateCarRequest;
import com.spring.rentACar.services.dtos.responses.car.GetCarListResponse;
import com.spring.rentACar.services.dtos.responses.car.GetCarResponse;

import java.util.List;

public interface CarService {
    void add(AddCarRequest addCarRequest);
    void update(int id, UpdateCarRequest updateCarRequest);
    List<GetCarListResponse> getAll();
    GetCarResponse getById(int id);
    void delete(int id);
}
