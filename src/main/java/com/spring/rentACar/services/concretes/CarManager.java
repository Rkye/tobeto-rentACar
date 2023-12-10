package com.spring.rentACar.services.concretes;

import com.spring.rentACar.entities.Car;
import com.spring.rentACar.repositories.CarRepository;
import com.spring.rentACar.services.abstracts.CarService;
import com.spring.rentACar.services.dtos.requests.car.AddCarRequest;
import com.spring.rentACar.services.dtos.requests.car.UpdateCarRequest;
import com.spring.rentACar.services.dtos.responses.car.GetCarListResponse;
import com.spring.rentACar.services.dtos.responses.car.GetCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class CarManager implements CarService {

    private final CarRepository carRepository;

    @Override
    public void add(AddCarRequest addCarRequest) {

        if(!Pattern.matches("[a-zA-Z]+",addCarRequest.getColor()))
            throw new RuntimeException("Sadece harf girilmeli.");

        Car car = new Car();
        car.setColor(addCarRequest.getColor());
        car.setModelName(addCarRequest.getModelName());
        car.setPrice(addCarRequest.getPrice());
        car.setModelYear(addCarRequest.getModelYear());
        car.setBrand(addCarRequest.getBrand());
        carRepository.save(car);
    }

    @Override
    public void update(int id, UpdateCarRequest updateCarRequest) {
        Car carToUpdate = carRepository.findById(id).orElseThrow();
        carToUpdate.setColor(updateCarRequest.getColor());
        carToUpdate.setPrice(updateCarRequest.getPrice());
        carToUpdate.setModelName(updateCarRequest.getModelName());
        carToUpdate.setModelYear(updateCarRequest.getModelYear());

        carRepository.save(carToUpdate);
    }

    @Override
    public List<GetCarListResponse> getAll() {
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

    @Override
    public GetCarResponse getById(int id) {
        Car car = carRepository.findById(id).orElseThrow();
        GetCarResponse getCarResponse = new GetCarResponse();
        getCarResponse.setColor(car.getColor());
        getCarResponse.setPrice(car.getPrice());
        getCarResponse.setModelName(car.getModelName());
        getCarResponse.setModelYear(car.getModelYear());
        getCarResponse.setBrandName(car.getBrand().getName());
        return getCarResponse;
    }

    @Override
    public void delete(int id) {
        carRepository.deleteById(id);
    }

    @Override
    public List<GetCarListResponse> getModelNameContain(String modelName) {
        List<Car> cars = carRepository.findByModelNameContaining(modelName);
        List<GetCarListResponse> responses = new ArrayList<>();
        for (Car car : cars){
            responses.add(new GetCarListResponse(car.getModelYear(), car.getModelName(), car.getPrice()));
        }
        return responses;
    }

    @Override
    public List<GetCarListResponse> getModelYearIsNot(int year) {
        List<Car> cars = carRepository.findByModelYearIsNot(year);
        List<GetCarListResponse> responses = new ArrayList<>();
        for (Car car : cars){
            responses.add(new GetCarListResponse(car.getModelYear(), car.getModelName(), car.getPrice()));
        }
        return responses;
    }

    @Override
    public List<GetCarListResponse> getByModelGreaterThanYear(int year) {
        return carRepository.getByModelGreaterThanYear(year);
    }

    @Override
    public List<GetCarListResponse> getByModelNameLessThanPrice(double price) {
        return carRepository.getByModelNameLessThanPrice(price);
    }
}
