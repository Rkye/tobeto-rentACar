package com.spring.rentACar.controllers;

import com.spring.rentACar.dtos.requests.car.AddCarRequest;
import com.spring.rentACar.dtos.requests.car.UpdateCarRequest;
import com.spring.rentACar.dtos.responses.car.GetCarListResponse;
import com.spring.rentACar.dtos.responses.car.GetCarResponse;
import com.spring.rentACar.entities.Car;
import com.spring.rentACar.repositories.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController {

    private final CarRepository carRepository;

    public CarsController(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    @GetMapping
    public List<GetCarListResponse> getAll(){
        List<Car> cars = carRepository.findAll();
        List<GetCarListResponse> getCarListResponses = new ArrayList<>();
        for (Car car:cars) {
            GetCarListResponse getCarListResponse = new GetCarListResponse();
            getCarListResponse.setModelName(car.getModelName());
            getCarListResponse.setPrice(car.getPrice());
            getCarListResponse.setModelYear(car.getModelYear());
            getCarListResponses.add(getCarListResponse);
        }
        return getCarListResponses;
    }

    @GetMapping("{id}")
    public GetCarResponse getById(@PathVariable int id){
        Car car = carRepository.findById(id).orElseThrow();
        GetCarResponse getCarResponse = new GetCarResponse();
        getCarResponse.setColor(car.getColor());
        getCarResponse.setPrice(car.getPrice());
        getCarResponse.setModelName(car.getModelName());
        getCarResponse.setModelYear(car.getModelYear());
        getCarResponse.setBrandName(car.getBrand().getName());
        return getCarResponse;
    }

    @PostMapping
    public void add(@RequestBody AddCarRequest addCarRequest){
        Car car = new Car();
        car.setColor(addCarRequest.getColor());
        car.setModelName(addCarRequest.getModelName());
        car.setPrice(addCarRequest.getPrice());
        car.setModelYear(addCarRequest.getModelYear());
        car.setBrand(addCarRequest.getBrand());
        carRepository.save(car);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateCarRequest updateCarRequest){
        Car carToUpdate = carRepository.findById(id).orElseThrow();
            carToUpdate.setColor(updateCarRequest.getColor());
            carToUpdate.setPrice(updateCarRequest.getPrice());
            carToUpdate.setModelName(updateCarRequest.getModelName());
            carToUpdate.setModelYear(updateCarRequest.getModelYear());

        carRepository.save(carToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        carRepository.deleteById(id);
    }



}
