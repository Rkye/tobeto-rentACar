package com.spring.rentACar.controllers;

import com.spring.rentACar.services.abstracts.CityService;
import com.spring.rentACar.services.dtos.requests.city.AddCityRequest;
import com.spring.rentACar.services.dtos.requests.city.UpdateCityRequest;
import com.spring.rentACar.services.dtos.responses.city.GetCityListResponse;
import com.spring.rentACar.services.dtos.responses.city.GetCityResponse;
import com.spring.rentACar.entities.City;
import com.spring.rentACar.repositories.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/cities")
@AllArgsConstructor
public class CitiesController {

    private final CityService cityService;


    @GetMapping
    public List<GetCityListResponse> cities(){
        return cityService.getAll();
    }

    @GetMapping("{id}")
    public GetCityResponse getById(@PathVariable int id){
        return cityService.getById(id);
    }

    @GetMapping("getCityStartingWith")
    public List<GetCityListResponse> getCityStartingWith(String prefix){
        return cityService.getByNameStartingWith(prefix);
    }

    @GetMapping("getNameNotNull")
    public List<GetCityListResponse> getByNameNotNull(){
        return cityService.getByNameNotNull();
    }

    @PostMapping
    public void add(@RequestBody AddCityRequest addCityRequest){
        cityService.add(addCityRequest);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateCityRequest updateCityRequest){
        cityService.update(id, updateCityRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        cityService.delete(id);
    }

    @GetMapping("getByNameEndsWithJPQL")
    public List<GetCityListResponse> getByNameEndsWithJPQL(String name){
        return cityService.getByNameEndsWith(name);
    }

    @GetMapping("getNameLengthGreaterThanJPQL")
    public List<GetCityListResponse> getNameLengthGreaterThanJPQL(int length){
        return cityService.getNameLengthGreaterThan(length);
    }
}
