package com.spring.rentACar.repositories;

import com.spring.rentACar.entities.Car;
import com.spring.rentACar.services.dtos.responses.car.GetCarListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    // Derived Query Method - 1
    List<Car> findByModelNameContaining(String modelName);

    // Derived Query Method - 2
    List<Car> findByModelYearIsNot(int year);

    // JPQL - 1
    @Query("Select new com.spring.rentACar.services.dtos.responses.car.GetCarListResponse(c.modelYear, c.modelName, c.price)" +
            " from Car c where c.modelYear >= :year")
    List<GetCarListResponse> getByModelGreaterThanYear(int year);

    //JPQL - 2
    @Query("Select new com.spring.rentACar.services.dtos.responses.car.GetCarListResponse(c.modelYear, c.modelName, c.price)" +
            " from Car c where c.price <= :price")
    List<GetCarListResponse> getByModelNameLessThanPrice(double price);

}
