package com.spring.rentACar.services.concretes;

import com.spring.rentACar.entities.Order;
import com.spring.rentACar.repositories.OrderRepository;
import com.spring.rentACar.services.abstracts.OrderService;
import com.spring.rentACar.services.dtos.requests.order.AddOrderRequest;
import com.spring.rentACar.services.dtos.requests.order.UpdateOrderRequest;
import com.spring.rentACar.services.dtos.responses.order.GetOrderListResponse;
import com.spring.rentACar.services.dtos.responses.order.GetOrderResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderManager implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public void add(AddOrderRequest addOrderRequest) {
        Order order = new Order();
        order.setStartDate(addOrderRequest.getStartDate());
        order.setEndDate(addOrderRequest.getEndDate());
        order.setPaymentType(addOrderRequest.getPaymentType());
        orderRepository.save(order);
    }

    @Override
    public GetOrderResponse getById(int id) {
        Order order = orderRepository.findById(id).orElseThrow();
        GetOrderResponse getOrderResponse = new GetOrderResponse();
        getOrderResponse.setDate(order.getDate());
        getOrderResponse.setTotalPrice(order.getTotalPrice());
        getOrderResponse.setEndDate(order.getEndDate());
        getOrderResponse.setStartDate(order.getStartDate());
        getOrderResponse.setPaymentType(order.getPaymentType());
        return getOrderResponse;
    }

    @Override
    public List<GetOrderListResponse> getAll() {
        List<Order> orders = orderRepository.findAll();
        List<GetOrderListResponse> getOrderListResponses = new ArrayList<>();
        for (Order order:orders) {
            GetOrderListResponse getOrderListResponse = new GetOrderListResponse();
            getOrderListResponse.setDate(order.getDate());
            getOrderListResponse.setTotalPrice(order.getTotalPrice());
            getOrderListResponses.add(getOrderListResponse);
        }
        return getOrderListResponses;
    }

    @Override
    public void update(int id, UpdateOrderRequest updateOrderRequest) {
        Order orderToUpdate = orderRepository.findById(id).orElseThrow();
        orderToUpdate.setStartDate(updateOrderRequest.getStartDate());
        orderToUpdate.setEndDate(updateOrderRequest.getEndDate());
        orderToUpdate.setTotalPrice(orderToUpdate.getTotalPrice());
        orderRepository.save(orderToUpdate);
    }

    @Override
    public void delete(int id) {
        orderRepository.deleteById(id);
    }
}
