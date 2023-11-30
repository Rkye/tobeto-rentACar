package com.spring.rentACar.controllers;

import com.spring.rentACar.services.abstracts.CountyService;
import com.spring.rentACar.services.dtos.requests.county.AddCountyRequest;
import com.spring.rentACar.services.dtos.requests.county.UpdateCountyRequest;
import com.spring.rentACar.services.dtos.responses.county.GetCountyListResponse;
import com.spring.rentACar.services.dtos.responses.county.GetCountyResponse;
import com.spring.rentACar.entities.County;
import com.spring.rentACar.repositories.CountyRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/counties")
@AllArgsConstructor
public class CountiesController {

    private final CountyService countyService;


    @GetMapping
    public List<GetCountyListResponse> getAll(){
        return countyService.getAll();
    }

    @GetMapping("{id}")
    public GetCountyResponse getById(@PathVariable int id){
        return countyService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddCountyRequest addCountyRequest){
        countyService.add(addCountyRequest);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateCountyRequest updateCountyRequest){
        countyService.update(id, updateCountyRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        countyService.delete(id);
    }

}
