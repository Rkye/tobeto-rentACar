package com.spring.rentACar.controllers;

import com.spring.rentACar.dtos.requests.city.AddCityRequest;
import com.spring.rentACar.dtos.requests.city.UpdateCityRequest;
import com.spring.rentACar.dtos.responses.city.GetCityListResponse;
import com.spring.rentACar.dtos.responses.city.GetCityResponse;
import com.spring.rentACar.entities.City;
import com.spring.rentACar.repositories.CityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/cities")
public class CitiesController {

    private final CityRepository cityRepository;

    public CitiesController(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    @GetMapping
    public List<GetCityListResponse> cities(){
        List<City> cities = cityRepository.findAll();
        List<GetCityListResponse> getCityListResponses = new ArrayList<>();
        for (City city:cities) {
            GetCityListResponse getCityListResponse = new GetCityListResponse();
            getCityListResponse.setName(city.getName());
            getCityListResponses.add(getCityListResponse);
        }
        return getCityListResponses;
    }

    @GetMapping("{id}")
    public GetCityResponse getById(@PathVariable int id){
        City city = cityRepository.findById(id).orElseThrow();
        GetCityResponse getCityResponse = new GetCityResponse();
        getCityResponse.setName(city.getName());
        return getCityResponse;
    }

    @PostMapping
    public void add(@RequestBody AddCityRequest addCityRequest){
        City city = new City();
        city.setName(addCityRequest.getName());
        cityRepository.save(city);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateCityRequest updateCityRequest){
        City cityToUpdate = cityRepository.findById(id).orElseThrow();
            cityToUpdate.setName(updateCityRequest.getName());
        cityRepository.save(cityToUpdate);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        cityRepository.deleteById(id);
    }
}
