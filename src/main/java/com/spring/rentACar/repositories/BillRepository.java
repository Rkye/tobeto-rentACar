package com.spring.rentACar.repositories;

import com.spring.rentACar.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Integer> {
}
