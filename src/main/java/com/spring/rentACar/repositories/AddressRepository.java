package com.spring.rentACar.repositories;

import com.spring.rentACar.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
