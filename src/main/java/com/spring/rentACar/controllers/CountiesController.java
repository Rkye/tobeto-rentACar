package com.spring.rentACar.controllers;

import com.spring.rentACar.dtos.requests.county.AddCountyRequest;
import com.spring.rentACar.dtos.requests.county.UpdateCountyRequest;
import com.spring.rentACar.dtos.responses.county.GetCountyListResponse;
import com.spring.rentACar.dtos.responses.county.GetCountyResponse;
import com.spring.rentACar.entities.County;
import com.spring.rentACar.repositories.CountyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/counties")
public class CountiesController {

    private final CountyRepository countyRepository;

    public CountiesController(CountyRepository countyRepository){
        this.countyRepository = countyRepository;
    }

    @GetMapping
    public List<GetCountyListResponse> getAll(){
        List<County> counties = countyRepository.findAll();
        List<GetCountyListResponse> getCountyListResponses = new ArrayList<>();
        for (County county : counties){
            GetCountyListResponse getCountyListResponse = new GetCountyListResponse();
            getCountyListResponse.setName(county.getName());
            getCountyListResponses.add(getCountyListResponse);
        }
        return getCountyListResponses;
    }

    @GetMapping("{id}")
    public GetCountyResponse getById(@PathVariable int id){
        County county = countyRepository.findById(id).orElseThrow();
        GetCountyResponse getCountyResponse = new GetCountyResponse();
        getCountyResponse.setName(county.getName());
        getCountyResponse.setCityName(county.getCity().getName());
        return getCountyResponse;
    }

    @PostMapping
    public void add(@RequestBody AddCountyRequest addCountyRequest){
        County county = new County();
        county.setName(addCountyRequest.getName());
        county.setCity(addCountyRequest.getCity());
        countyRepository.save(county);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateCountyRequest updateCountyRequest){
        County countyToUpdate = countyRepository.findById(id).orElseThrow();
            countyToUpdate.setName(updateCountyRequest.getName());
            countyToUpdate.setCity(updateCountyRequest.getCity());
        countyRepository.save(countyToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        countyRepository.deleteById(id);
    }

}
