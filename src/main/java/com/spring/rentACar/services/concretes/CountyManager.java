package com.spring.rentACar.services.concretes;

import com.spring.rentACar.entities.County;
import com.spring.rentACar.repositories.CountyRepository;
import com.spring.rentACar.services.abstracts.CountyService;
import com.spring.rentACar.services.dtos.requests.county.AddCountyRequest;
import com.spring.rentACar.services.dtos.requests.county.UpdateCountyRequest;
import com.spring.rentACar.services.dtos.responses.city.GetCityResponse;
import com.spring.rentACar.services.dtos.responses.county.GetCountyListResponse;
import com.spring.rentACar.services.dtos.responses.county.GetCountyResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CountyManager implements CountyService {

    private final CountyRepository countyRepository;

    @Override
    public void add(AddCountyRequest addCountyRequest) {
        County county = new County();
        county.setName(addCountyRequest.getName());
        county.setCity(addCountyRequest.getCity());
        countyRepository.save(county);
    }

    @Override
    public GetCountyResponse getById(int id) {
        County county = countyRepository.findById(id).orElseThrow();
        GetCountyResponse getCountyResponse = new GetCountyResponse();
        getCountyResponse.setName(county.getName());
        //getCountyResponse.setCityResponse();
        return getCountyResponse;
    }

    @Override
    public List<GetCountyListResponse> getAll() {
        List<County> counties = countyRepository.findAll();
        List<GetCountyListResponse> getCountyListResponses = new ArrayList<>();
        for (County county : counties){
            GetCountyListResponse getCountyListResponse = new GetCountyListResponse();
            getCountyListResponse.setName(county.getName());
            getCountyListResponses.add(getCountyListResponse);
        }
        return getCountyListResponses;
    }

    @Override
    public void update(int id, UpdateCountyRequest updateCountyRequest) {
        County countyToUpdate = countyRepository.findById(id).orElseThrow();
        countyToUpdate.setName(updateCountyRequest.getName());
        countyToUpdate.setCity(updateCountyRequest.getCity());
        countyRepository.save(countyToUpdate);
    }

    @Override
    public void delete(int id) {
        countyRepository.deleteById(id);
    }

    @Override
    public List<GetCountyListResponse> getByNameNotLike(String name) {
        List<County> counties = countyRepository.findByNameNotLike(name);
        List<GetCountyListResponse> responses = new ArrayList<>();
        for (County county : counties){
            responses.add(new GetCountyListResponse(county.getName()));
        }
        return responses;
    }

    @Override
    public List<GetCountyListResponse> getByName(String name) {
        List<County> counties = countyRepository.findByName(name);
        List<GetCountyListResponse> responses = new ArrayList<>();
        for (County county : counties){
            responses.add(new GetCountyListResponse(county.getName()));
        }
        return responses;
    }

    @Override
    public GetCountyResponse getByIdQuery(int id) {
        return countyRepository.getByIdQuery(id);
    }

    @Override
    public List<GetCountyListResponse> getNameStartsWith(String name) {
        return countyRepository.getNameStartsWith(name);
    }
}
