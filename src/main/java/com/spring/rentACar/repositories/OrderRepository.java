package com.spring.rentACar.repositories;

import com.spring.rentACar.entities.Order;
import com.spring.rentACar.services.dtos.responses.order.GetOrderListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    // Derived Query Method - 1
    List<Order> findByDateBetween(LocalDate date1, LocalDate date2);

    // Derived Query Method - 2
    List<Order> findByDateOrderByTotalPrice(LocalDate date);

    // JPQL - 1
    @Query("Select new com.spring.rentACar.services.dtos.responses.order.GetOrderListResponse(o.date, o.startDate," +
            "o.endDate, o.totalPrice, o.paymentType)" +
            " from Order o where o.date between :date1 and :date2")
    List<GetOrderListResponse> getByOrderBetweenDate(LocalDate date1, LocalDate date2);

    // JPQL - 2
    @Query("Select new com.spring.rentACar.services.dtos.responses.order." +
            "GetOrderListResponse(o.date, o.startDate,o.endDate, o.totalPrice, o.paymentType) " +
            "from Order o where o.date between :date1 and :date2 order by o.totalPrice desc")
    List<GetOrderListResponse> getOrderByPriceBetweenDate(LocalDate date1, LocalDate date2);
}
