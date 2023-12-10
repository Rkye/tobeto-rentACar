package com.spring.rentACar.repositories;

import com.spring.rentACar.entities.Brand;
import com.spring.rentACar.services.dtos.responses.brand.GetBrandListResponse;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

    boolean existsByName(String name);

    // Derived Query Method - 1
    List<Brand> findByNameLike(String name);

    // Derived Query Method - 2
    List<Brand> findByNameOrderByNameDesc(String name);

    // JPQL - 1
    @Query("Select new com.spring.rentACar.services.dtos.responses.brand.GetBrandListResponse(b.name) from Brand b order by b.name desc")
    List<GetBrandListResponse> getByNameOrderBy();

    //JPQL - 2
    @Query("Select new com.spring.rentACar.services.dtos.responses.brand.GetBrandListResponse(b.name) from Brand b where b.name like %:name%")
    List<GetBrandListResponse> getByNameLike(String name);

}
