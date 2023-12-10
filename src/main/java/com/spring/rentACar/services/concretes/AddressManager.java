package com.spring.rentACar.services.concretes;

import com.spring.rentACar.entities.Address;
import com.spring.rentACar.repositories.AddressRepository;
import com.spring.rentACar.services.abstracts.AddressService;
import com.spring.rentACar.services.dtos.requests.address.AddAddressRequest;
import com.spring.rentACar.services.dtos.requests.address.UpdateAddressRequest;
import com.spring.rentACar.services.dtos.responses.address.GetAddressListResponse;
import com.spring.rentACar.services.dtos.responses.address.GetAddressResponse;
import com.spring.rentACar.services.dtos.responses.city.GetCityResponse;
import com.spring.rentACar.services.dtos.responses.county.GetCountyResponse;
import lombok.AllArgsConstructor;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class AddressManager implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public void add(AddAddressRequest addAddressRequest) {

        if(!Pattern.matches("[0-9]+",addAddressRequest.getPostalCode()) || addAddressRequest.getPostalCode().length() != 5)
            throw new RuntimeException("Sadece rakam girilmeli.");

        Address address = new Address();
        address.setPostalCode(addAddressRequest.getPostalCode());
        address.setAddressText(addAddressRequest.getAddressText());
        //TODO address.setCounty(addAddressRequest.getCounty());
        //TODO address.setCİty(addAddressRequest.getCİty());
        addressRepository.save(address);
    }

    @Override
    public GetAddressResponse getById(int id) {
        Address address = addressRepository.findById(id).orElseThrow();
        GetAddressResponse getAddressResponse = new GetAddressResponse();
        GetCountyResponse countyResponse = new GetCountyResponse(address.getCounty().getName(),new GetCityResponse(address.getCity().getName()));
        getAddressResponse.setAddressText(address.getAddressText());
        getAddressResponse.setPostalCode(address.getPostalCode());
        getAddressResponse.setResponse(countyResponse);
        return getAddressResponse;
    }

    @Override
    public List<GetAddressListResponse> getAll() {
        List<Address> Addresses= addressRepository.findAll();
        List<GetAddressListResponse> getAddressListResponses = new ArrayList<>();
        for (Address address:Addresses) {
            GetAddressListResponse getAddressListResponse = new GetAddressListResponse();
            GetCityResponse response = new GetCityResponse(address.getCity().getName());
            getAddressListResponse.setAddressText(address.getAddressText());
            getAddressListResponse.setPostalCode(address.getPostalCode());
            getAddressListResponse.setCity(response);
            getAddressListResponses.add(getAddressListResponse);
        }
        return getAddressListResponses;
    }

    @Override
    public void update(int id, UpdateAddressRequest updateAddressRequest) {
        Address addressToUpdate = addressRepository.findById(id).orElseThrow();
        addressToUpdate.setAddressText(updateAddressRequest.getAddressText());
        addressToUpdate.setPostalCode(updateAddressRequest.getPostalCode());
        addressRepository.save(addressToUpdate);
    }

    @Override
    public void delete(int id) {
        addressRepository.deleteById(id);
    }

    @Override
    public List<GetAddressListResponse> getPostalCodeEquals(String postalCode) {
        List<Address> addresses = addressRepository.findByPostalCodeEquals(postalCode);
        List<GetAddressListResponse> listResponses = new ArrayList<>();
        for (Address address : addresses){
            GetCityResponse getCityResponse=new GetCityResponse(address.getCity().getName());
            listResponses.add(new GetAddressListResponse(address.getPostalCode(),address.getAddressText(),getCityResponse));
        }
        return listResponses;
    }


    @Override
    public List<GetAddressListResponse> getPostalCodeIsNull() {
        List<Address> addresses = addressRepository.findByPostalCodeNull();
        List<GetAddressListResponse> responses = new ArrayList<>();
        for (Address address : addresses){
            responses.add(new GetAddressListResponse(address.getPostalCode(),address.getAddressText(), new GetCityResponse(address.getCity().getName())));
        }
        return responses;
    }

    @Override
    public List<GetAddressListResponse> getAllAddressQuery() {
        return addressRepository.getAllQuery();
    }

    @Override
    public GetAddressResponse getByIdJPQL(int id) {
        return addressRepository.getByIdJPQL(id);
    }

}
