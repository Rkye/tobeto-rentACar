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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class OrderManager implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public void add(AddOrderRequest addOrderRequest) {

        if(!Pattern.matches("[a-zA-Z]+",addOrderRequest.getPaymentType()))
            throw new RuntimeException("Rakam girilemez.");

        Order order = new Order();
        order.setDate(addOrderRequest.getDate());
        order.setStartDate(addOrderRequest.getStartDate());
        order.setEndDate(addOrderRequest.getEndDate());
        order.setTotalPrice(addOrderRequest.getTotalPrice());
        order.setPaymentType(addOrderRequest.getPaymentType());
        orderRepository.save(order);
    }

    @Override
    public GetOrderResponse getById(int id) {
        Order order = orderRepository.findById(id).orElseThrow();
        GetOrderResponse getOrderResponse = new GetOrderResponse();
        getOrderResponse.setDate(order.getDate());
        getOrderResponse.setStartDate(order.getStartDate());
        getOrderResponse.setEndDate(order.getEndDate());
        getOrderResponse.setTotalPrice(order.getTotalPrice());
        getOrderResponse.setPaymentType(order.getPaymentType());
        return getOrderResponse;
    }

    @Override
    public List<GetOrderListResponse> getAll() {
        List<Order> orders = orderRepository.findAll();
        List<GetOrderListResponse> getOrderListResponses = new ArrayList<>();
        for (Order order:orders) {
            getOrderListResponses.add(new GetOrderListResponse(order.getDate(),order.getStartDate(),
                    order.getEndDate(), order.getTotalPrice(),  order.getPaymentType()));
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

    @Override
    public List<GetOrderListResponse> getByDateBetween(LocalDate date1, LocalDate date2) {
        List<Order> orders = orderRepository.findByDateBetween(date1, date2);
        List<GetOrderListResponse> responses = new ArrayList<>();
        for (Order order : orders){
            responses.add(new GetOrderListResponse(order.getDate(),order.getStartDate(),
                    order.getEndDate(), order.getTotalPrice(),  order.getPaymentType()));
        }
        return responses;
    }

    @Override
    public List<GetOrderListResponse> getByDateOrderByTotalPrice(LocalDate date) {
        List<Order> orders = orderRepository.findByDateOrderByTotalPrice(date);
        List<GetOrderListResponse> responses = new ArrayList<>();
        for (Order order : orders){
            responses.add(new GetOrderListResponse(order.getDate(),order.getStartDate(),
                    order.getEndDate(), order.getTotalPrice(),  order.getPaymentType()));
        }
        return responses;
    }

    @Override
    public List<GetOrderListResponse> getByOrderBetweenDate(LocalDate date1, LocalDate date2) {
        return orderRepository.getByOrderBetweenDate(date1,date2);
    }

    @Override
    public List<GetOrderListResponse> getOrderByPriceDescBetweenDate(LocalDate date1, LocalDate date2) {
        return orderRepository.getOrderByPriceBetweenDate(date1, date2);
    }
}
