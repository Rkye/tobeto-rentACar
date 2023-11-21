package com.spring.rentACar.controllers;

import com.spring.rentACar.entities.Bill;
import com.spring.rentACar.repositories.BillRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bills")
public class BillsController {
    private final BillRepository billRepository;

    public BillsController(BillRepository billRepository){
        this.billRepository = billRepository;
    }

    @GetMapping
    public List<Bill> getAll(){
        return billRepository.findAll();
    }

    @GetMapping("{id}")
    public Bill getById(@PathVariable int id){
        return billRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Bill bill){
        billRepository.save(bill);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Bill bill){
        Bill billToUpdate = billRepository.findById(id).orElseThrow();
            billToUpdate.setAddress(bill.getAddress());
            billToUpdate.setDate(bill.getDate());
            billToUpdate.setCustomer(bill.getCustomer());
            billToUpdate.setPrice(bill.getPrice());
        billRepository.save(billToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        billRepository.deleteById(id);
    }

}
