package com.spring.rentACar.repositories;

import com.spring.rentACar.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
