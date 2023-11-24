package com.spring.rentACar.controllers;

import com.spring.rentACar.dtos.requests.order.AddOrderRequest;
import com.spring.rentACar.dtos.requests.order.UpdateOrderRequest;
import com.spring.rentACar.dtos.responses.order.GetOrderListResponse;
import com.spring.rentACar.dtos.responses.order.GetOrderResponse;
import com.spring.rentACar.entities.Order;
import com.spring.rentACar.repositories.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrdersController {

    private final OrderRepository orderRepository;

    public OrdersController(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<GetOrderListResponse> getAll(){
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

    @GetMapping("{id}")
    public GetOrderResponse getById(@PathVariable int id){
        Order order = orderRepository.findById(id).orElseThrow();
        GetOrderResponse getOrderResponse = new GetOrderResponse();
        getOrderResponse.setDate(order.getDate());
        getOrderResponse.setTotalPrice(order.getTotalPrice());
        getOrderResponse.setEndDate(order.getEndDate());
        getOrderResponse.setStartDate(order.getStartDate());
        getOrderResponse.setPaymentType(order.getPaymentType());
        return getOrderResponse;
    }

    @PostMapping
    public void add(@RequestBody AddOrderRequest addOrderRequest){
        Order order = new Order();
        order.setStartDate(addOrderRequest.getStartDate());
        order.setEndDate(addOrderRequest.getEndDate());
        order.setPaymentType(addOrderRequest.getPaymentType());
        orderRepository.save(order);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateOrderRequest updateOrderRequest){
        Order orderToUpdate = orderRepository.findById(id).orElseThrow();
            orderToUpdate.setStartDate(updateOrderRequest.getStartDate());
            orderToUpdate.setEndDate(updateOrderRequest.getEndDate());
            orderToUpdate.setTotalPrice(orderToUpdate.getTotalPrice());
        orderRepository.save(orderToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        orderRepository.deleteById(id);
    }

}
