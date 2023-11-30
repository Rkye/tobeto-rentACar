package com.spring.rentACar.controllers;

import com.spring.rentACar.services.abstracts.OrderService;
import com.spring.rentACar.services.dtos.requests.order.AddOrderRequest;
import com.spring.rentACar.services.dtos.requests.order.UpdateOrderRequest;
import com.spring.rentACar.services.dtos.responses.order.GetOrderListResponse;
import com.spring.rentACar.services.dtos.responses.order.GetOrderResponse;
import com.spring.rentACar.entities.Order;
import com.spring.rentACar.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/orders")
@AllArgsConstructor
public class OrdersController {

    private final OrderService orderService;

    @GetMapping
    public List<GetOrderListResponse> getAll(){
        return orderService.getAll();
    }

    @GetMapping("{id}")
    public GetOrderResponse getById(@PathVariable int id){
        return orderService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddOrderRequest addOrderRequest){
        orderService.add(addOrderRequest);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateOrderRequest updateOrderRequest){
        orderService.update(id, updateOrderRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        orderService.delete(id);
    }

}
