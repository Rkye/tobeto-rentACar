package com.spring.rentACar.services.concretes;

import com.spring.rentACar.entities.Address;
import com.spring.rentACar.repositories.AddressRepository;
import com.spring.rentACar.services.abstracts.AddressService;
import com.spring.rentACar.services.dtos.requests.address.AddAddressRequest;
import com.spring.rentACar.services.dtos.requests.address.UpdateAddressRequest;
import com.spring.rentACar.services.dtos.responses.address.GetAddressListResponse;
import com.spring.rentACar.services.dtos.responses.address.GetAddressResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class AddressManager implements AddressService {

    private final AddressRepository addressRepository;
    @Override
    public void add(AddAddressRequest addAddressRequest) {
        Address address = new Address();
        address.setPostalCode(addAddressRequest.getPostalCode());
        address.setAddressText(addAddressRequest.getAddressText());
        address.setCounty(addAddressRequest.getCounty());
        addressRepository.save(address);
    }

    @Override
    public GetAddressResponse getById(int id) {
        Address address = addressRepository.findById(id).orElseThrow();
        GetAddressResponse getAddressResponse = new GetAddressResponse();
        getAddressResponse.setAddressText(address.getAddressText());
        getAddressResponse.setPostalCode(address.getPostalCode());
        getAddressResponse.setCountyName(address.getCounty().getName());
        getAddressResponse.setCityName(address.getCounty().getCity().getName());
        return getAddressResponse;
    }

    @Override
    public List<GetAddressListResponse> getAll() {
        List<Address> Addresses= addressRepository.findAll();
        List<GetAddressListResponse> getAddressListResponses = new ArrayList<>();
        for (Address address:Addresses) {
            GetAddressListResponse getAddressListResponse = new GetAddressListResponse();
            getAddressListResponse.setAddressText(address.getAddressText());
            getAddressListResponse.setPostalCode(address.getPostalCode());
            getAddressListResponses.add(getAddressListResponse);
        }
        return getAddressListResponses;
    }

    @Override
    public void update(int id, UpdateAddressRequest updateAddressRequest) {
        Address addressToUpdate = addressRepository.findById(id).orElseThrow();
        addressToUpdate.setAddressText(updateAddressRequest.getAddressText());
        addressToUpdate.setPostalCode(updateAddressRequest.getPostalCode());
        addressToUpdate.setCounty(updateAddressRequest.getCounty());
        addressRepository.save(addressToUpdate);
    }

    @Override
    public void delete(int id) {
        addressRepository.deleteById(id);
    }
}
