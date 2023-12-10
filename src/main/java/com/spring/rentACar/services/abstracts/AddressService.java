package com.spring.rentACar.services.abstracts;

import com.spring.rentACar.services.dtos.requests.address.AddAddressRequest;
import com.spring.rentACar.services.dtos.requests.address.UpdateAddressRequest;
import com.spring.rentACar.services.dtos.responses.address.GetAddressListResponse;
import com.spring.rentACar.services.dtos.responses.address.GetAddressResponse;

import java.util.List;

public interface AddressService {
    void add(AddAddressRequest addAddressRequest);
    GetAddressResponse getById(int id);
    List<GetAddressListResponse> getAll();
    void update(int id, UpdateAddressRequest updateAddressRequest);
    void delete(int id);
    List<GetAddressListResponse> getPostalCodeEquals(String postalCode);
    List<GetAddressListResponse> getPostalCodeIsNull();
    List<GetAddressListResponse> getAllAddressQuery();
    GetAddressResponse getByIdJPQL(int id);
}
