package com.spring.rentACar.repositories;

import com.spring.rentACar.entities.County;
import com.spring.rentACar.services.dtos.responses.county.GetCountyListResponse;
import com.spring.rentACar.services.dtos.responses.county.GetCountyResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountyRepository extends JpaRepository<County, Integer> {

    // Derived Query Method - 1
    List<County> findByNameNotLike(String name);

    // Derived Query Method - 2
    List<County> findByName(String name);

    // JPQL - 1
    @Query("Select new com.spring.rentACar.services.dtos.responses.county.GetCountyResponse(c.name, new " +
            "com.spring.rentACar.services.dtos.responses.city.GetCityResponse(ci.name)) from County c " +
            "inner join c.city ci where c.id = :id ")
    GetCountyResponse getByIdQuery(int id);

    // JPQL - 2
    @Query("Select new com.spring.rentACar.services." +
            "dtos.responses.county.GetCountyListResponse(c.name)" +
            " from County c where c.name like :name%")
    List<GetCountyListResponse> getNameStartsWith(String name);

}
