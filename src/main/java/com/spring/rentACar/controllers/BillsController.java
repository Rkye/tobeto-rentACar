package com.spring.rentACar.controllers;

import com.spring.rentACar.dtos.requests.bill.AddBillRequest;
import com.spring.rentACar.dtos.requests.bill.UpdateBillRequest;
import com.spring.rentACar.dtos.responses.bill.GetBillListResponse;
import com.spring.rentACar.dtos.responses.bill.GetBillResponse;
import com.spring.rentACar.entities.Bill;
import com.spring.rentACar.repositories.BillRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/bills")
public class BillsController {
    private final BillRepository billRepository;

    public BillsController(BillRepository billRepository){
        this.billRepository = billRepository;
    }

    @GetMapping
    public List<GetBillListResponse> getAll(){
        List<Bill> bills = billRepository.findAll();
        List<GetBillListResponse> getBillListResponses = new ArrayList<>();
        for (Bill bill:bills) {
            GetBillListResponse getBillListResponse = new GetBillListResponse();
            getBillListResponse.setDate(bill.getDate());
            getBillListResponse.setPrice(bill.getPrice());
            getBillListResponses.add(getBillListResponse);
        }
        return getBillListResponses;
    }

    @GetMapping("{id}")
    public GetBillResponse getById(@PathVariable int id){
        Bill bill = billRepository.findById(id).orElseThrow();
        GetBillResponse getBillResponse = new GetBillResponse();
        getBillResponse.setDate(bill.getDate());
        getBillResponse.setPrice(bill.getPrice());
        return getBillResponse;
    }

    @PostMapping
    public void add(@RequestBody AddBillRequest addBillRequest){
        Bill bill = new Bill();
        bill.setDate(addBillRequest.getDate());
        bill.setPrice(addBillRequest.getPrice());
        billRepository.save(bill);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateBillRequest updateBillRequest){
        Bill billToUpdate = billRepository.findById(id).orElseThrow();
            billToUpdate.setDate(updateBillRequest.getDate());
            billToUpdate.setPrice(updateBillRequest.getPrice());
        billRepository.save(billToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        billRepository.deleteById(id);
    }

}
