package com.spring.rentACar.services.abstracts;


import com.spring.rentACar.services.dtos.requests.bill.AddBillRequest;
import com.spring.rentACar.services.dtos.requests.bill.UpdateBillRequest;
import com.spring.rentACar.services.dtos.responses.bill.GetBillListResponse;
import com.spring.rentACar.services.dtos.responses.bill.GetBillResponse;

import java.util.List;

public interface BillService {
    void add(AddBillRequest addBillRequest);
    GetBillResponse getById(int id);
    List<GetBillListResponse> getAll();
    void update(int id, UpdateBillRequest updateBillRequest);
    void delete(int id);
}
