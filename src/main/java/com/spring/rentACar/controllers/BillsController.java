package com.spring.rentACar.controllers;

import com.spring.rentACar.services.abstracts.BillService;
import com.spring.rentACar.services.dtos.requests.bill.AddBillRequest;
import com.spring.rentACar.services.dtos.requests.bill.UpdateBillRequest;
import com.spring.rentACar.services.dtos.responses.bill.GetBillListResponse;
import com.spring.rentACar.services.dtos.responses.bill.GetBillResponse;
import com.spring.rentACar.entities.Bill;
import com.spring.rentACar.repositories.BillRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/bills")
@AllArgsConstructor
public class BillsController {
    private final BillService billService;

    @GetMapping
    public List<GetBillListResponse> getAll(){
        return billService.getAll();
    }

    @GetMapping("{id}")
    public GetBillResponse getById(@PathVariable int id){
        return billService.getById(id);
    }

    @GetMapping("getBillDateGreaterThan")
    public List<GetBillListResponse> getBillDateGreaterThan(LocalDate date){
        return billService.getDateGreaterThan(date);
    }

    @GetMapping("getByDateOrderByPrice")
    public List<GetBillListResponse> getByDateOrderByPrice(LocalDate date){
        return billService.getByDateOrderByPrice(date);
    }

    @GetMapping("getByDateJPQL")
    public List<GetBillListResponse> getByDateJPQL(LocalDate date){
        return billService.getByDate(date);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddBillRequest addBillRequest){
        billService.add(addBillRequest);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateBillRequest updateBillRequest){
        billService.update(id, updateBillRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        billService.delete(id);
    }

    @GetMapping("getAllJPQL")
    public List<GetBillListResponse> getAllJPQL(){
        return billService.getAllJPQL();
    }



}
