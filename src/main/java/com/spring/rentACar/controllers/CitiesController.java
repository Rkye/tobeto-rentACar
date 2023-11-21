package com.spring.rentACar.controllers;

import com.spring.rentACar.entities.City;
import com.spring.rentACar.repositories.CityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cities")
public class CitiesController {

    private final CityRepository cityRepository;

    public CitiesController(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    @GetMapping
    public List<City> cities(){
        return cityRepository.findAll();
    }

    @GetMapping("{id}")
    public City getById(@PathVariable int id){
        return cityRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody City city){
        cityRepository.save(city);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody City city){
        City cityToUpdate = cityRepository.findById(id).orElseThrow();
            cityToUpdate.setAdresses(city.getAdresses());
            cityToUpdate.setCounties(city.getCounties());
            cityToUpdate.setName(city.getName());
        cityRepository.save(cityToUpdate);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        cityRepository.deleteById(id);
    }
}
