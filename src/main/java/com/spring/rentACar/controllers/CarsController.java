package com.spring.rentACar.controllers;

import com.spring.rentACar.entities.Car;
import com.spring.rentACar.repositories.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController {

    private final CarRepository carRepository;

    public CarsController(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    @GetMapping
    public List<Car> getAll(){
        return carRepository.findAll();
    }

    @GetMapping("{id}")
    public Car getById(@PathVariable int id){
        return carRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Car car){
        carRepository.save(car);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Car car){
        Car carToUpdate = carRepository.findById(id).orElseThrow();
            carToUpdate.setBrand(car.getBrand());
            carToUpdate.setColor(car.getColor());
            carToUpdate.setPrice(car.getPrice());
            carToUpdate.setModelName(car.getModelName());
            carToUpdate.setModelYear(car.getModelYear());

        carRepository.save(carToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        carRepository.deleteById(id);
    }



}
