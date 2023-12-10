package com.spring.rentACar.services.abstracts;

import com.spring.rentACar.services.dtos.requests.order.AddOrderRequest;
import com.spring.rentACar.services.dtos.requests.order.UpdateOrderRequest;
import com.spring.rentACar.services.dtos.responses.order.GetOrderListResponse;
import com.spring.rentACar.services.dtos.responses.order.GetOrderResponse;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {
    void add(AddOrderRequest addOrderRequest);
    GetOrderResponse getById(int id);
    List<GetOrderListResponse> getAll();
    void update(int id, UpdateOrderRequest updateOrderRequest);
    void delete(int id);
    List<GetOrderListResponse> getByDateBetween(LocalDate date1, LocalDate date2);
    List<GetOrderListResponse> getByDateOrderByTotalPrice(LocalDate date);
    List<GetOrderListResponse> getByOrderBetweenDate(LocalDate date1, LocalDate date2);
    List<GetOrderListResponse> getOrderByPriceDescBetweenDate(LocalDate date1, LocalDate date2);
}
