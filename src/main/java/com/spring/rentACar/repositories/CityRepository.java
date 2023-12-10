package com.spring.rentACar.repositories;

import com.spring.rentACar.entities.City;
import com.spring.rentACar.services.dtos.responses.city.GetCityListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {

    // Derived Query Method - 1
    List<City> findByNameStartingWith(String name);

    // Derived Query Method - 2
    List<City> findByNameNotNull();

    // JPQL - 1
    @Query("Select new com.spring.rentACar.services.dtos.responses.city.GetCityListResponse(c.name)" +
            " from City c where c.name like %:name")
    List<GetCityListResponse> getByNameEndsWith(String name);

    @Query("Select new com.spring.rentACar.services.dtos.responses.city.GetCityListResponse(c.name)" +
            " from City c where length(c.name) >= :length")
    List<GetCityListResponse> getNameLengthGreaterThan(int length);
}

