package com.spring.rentACar.repositories;

import com.spring.rentACar.entities.County;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountyRepository extends JpaRepository<County, Integer> {
}
