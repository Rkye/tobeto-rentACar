package com.spring.rentACar.repositories;

import com.spring.rentACar.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}
