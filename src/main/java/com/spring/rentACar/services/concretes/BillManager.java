package com.spring.rentACar.services.concretes;

import com.spring.rentACar.entities.Bill;
import com.spring.rentACar.repositories.BillRepository;
import com.spring.rentACar.services.abstracts.BillService;
import com.spring.rentACar.services.dtos.requests.bill.AddBillRequest;
import com.spring.rentACar.services.dtos.requests.bill.UpdateBillRequest;
import com.spring.rentACar.services.dtos.responses.bill.GetBillListResponse;
import com.spring.rentACar.services.dtos.responses.bill.GetBillResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class BillManager implements BillService {

    private final BillRepository billRepository;

    @Override
    public void add(AddBillRequest addBillRequest) {
        Bill bill = new Bill();
        bill.setDate(addBillRequest.getDate());
        bill.setPrice(addBillRequest.getPrice());
        billRepository.save(bill);
    }

    @Override
    public GetBillResponse getById(int id) {
        Bill bill = billRepository.findById(id).orElseThrow();
        GetBillResponse getBillResponse = new GetBillResponse();
        getBillResponse.setDate(bill.getDate());
        getBillResponse.setPrice(bill.getPrice());
        return getBillResponse;
    }

    @Override
    public List<GetBillListResponse> getAll() {
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

    @Override
    public void update(int id, UpdateBillRequest updateBillRequest) {
        Bill billToUpdate = billRepository.findById(id).orElseThrow();
        billToUpdate.setDate(updateBillRequest.getDate());
        billToUpdate.setPrice(updateBillRequest.getPrice());
        billRepository.save(billToUpdate);
    }

    @Override
    public void delete(int id) {
        billRepository.deleteById(id);
    }

    @Override
    public List<GetBillListResponse> getDateGreaterThan(LocalDate date) {
        List<Bill> bills = billRepository.findByDateGreaterThanEqual(date);
        List<GetBillListResponse> getBillListResponses = new ArrayList<>();
        for (Bill bill : bills){
            getBillListResponses.add(new GetBillListResponse(bill.getDate(),bill.getPrice()));
        }
        return getBillListResponses;
    }

    @Override
    public List<GetBillListResponse> getByDateOrderByPrice(LocalDate date) {
        List<Bill> bills = billRepository.findByDateOrderByPriceDesc(date);
        List<GetBillListResponse> responses = new ArrayList<>();
        for (Bill bill : bills){
            responses.add(new GetBillListResponse(bill.getDate(),bill.getPrice()));
        }
        return responses;
    }

    @Override
    public List<GetBillListResponse> getAllJPQL() {
        return billRepository.getAllJPQL();
    }

    @Override
    public List<GetBillListResponse> getByDate(LocalDate date) {
        return billRepository.getByDateJPQL(date);
    }
}
