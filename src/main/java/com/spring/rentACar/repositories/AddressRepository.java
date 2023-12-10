package com.spring.rentACar.repositories;

import com.spring.rentACar.entities.Address;
import com.spring.rentACar.services.dtos.responses.address.GetAddressListResponse;
import com.spring.rentACar.services.dtos.responses.address.GetAddressResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    // Derived Query Method - 1
    List<Address> findByPostalCodeEquals(String postalCode);

    // Derived Query Method - 2
    List<Address> findByPostalCodeNull();

    // JPQL - 1
    @Query("Select new com.spring.rentACar.services.dtos.responses.address" +
            ".GetAddressListResponse(a.postalCode, a.addressText, new com.spring.rentACar.services.dtos.responses.city.GetCityResponse(c.name))"+
            " from Address a INNER JOIN a.city c")
    List<GetAddressListResponse> getAllQuery();

    // JPQL - 2
    @Query("SELECT new com.spring.rentACar.services.dtos.responses.address.GetAddressResponse(" +
            "a.postalCode, a.addressText, " +
            "new com.spring.rentACar.services.dtos.responses.county.GetCountyResponse(c.name, " +
            "new com.spring.rentACar.services.dtos.responses.city.GetCityResponse(ci.name))) " +
            "FROM Address a " +
            "INNER JOIN a.county c " +
            "INNER JOIN c.city ci " +
            "WHERE a.id = :id")
    GetAddressResponse getByIdJPQL(int id);

}
