package com.spring.rentACar.controllers;

import com.spring.rentACar.services.abstracts.CarService;
import com.spring.rentACar.services.dtos.requests.car.AddCarRequest;
import com.spring.rentACar.services.dtos.requests.car.UpdateCarRequest;
import com.spring.rentACar.services.dtos.responses.car.GetCarListResponse;
import com.spring.rentACar.services.dtos.responses.car.GetCarResponse;
import com.spring.rentACar.entities.Car;
import com.spring.rentACar.repositories.CarRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/cars")
@AllArgsConstructor
public class CarsController {

    private final CarService carService;

    @GetMapping
    public List<GetCarListResponse> getAll(){
        return carService.getAll();
    }

    @GetMapping("{id}")
    public GetCarResponse getById(@PathVariable int id){
        return carService.getById(id);
    }

    @GetMapping("getByModelNameContain")
    public List<GetCarListResponse> getByModelNameContain(String modelName){
        return carService.getModelNameContain(modelName);
    }

    @GetMapping("getModelYearIsNot")
    public List<GetCarListResponse> getModelYearIsNot(int year){
        return carService.getModelYearIsNot(year);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddCarRequest addCarRequest){
        carService.add(addCarRequest);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateCarRequest updateCarRequest){
        carService.update(id, updateCarRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        carService.delete(id);
    }

    @GetMapping("getByModelGreaterThanYearJPQL")
    public List<GetCarListResponse> getByModelGreaterThanYearJPQL(int year){
        return carService.getByModelGreaterThanYear(year);
    }

    @GetMapping("getByModelNameLessThanPriceJPQL")
    public List<GetCarListResponse> getByModelNameLessThanPriceJPQL(double price){
        return carService.getByModelNameLessThanPrice(price);
    }



}
