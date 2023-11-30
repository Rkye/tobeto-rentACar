package com.spring.rentACar.services.abstracts;

import com.spring.rentACar.services.dtos.requests.order.AddOrderRequest;
import com.spring.rentACar.services.dtos.requests.order.UpdateOrderRequest;
import com.spring.rentACar.services.dtos.responses.order.GetOrderListResponse;
import com.spring.rentACar.services.dtos.responses.order.GetOrderResponse;

import java.util.List;

public interface OrderService {
    void add(AddOrderRequest addOrderRequest);
    GetOrderResponse getById(int id);
    List<GetOrderListResponse> getAll();
    void update(int id, UpdateOrderRequest updateOrderRequest);
    void delete(int id);
}
