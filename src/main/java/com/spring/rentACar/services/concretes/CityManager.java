package com.spring.rentACar.services.concretes;

import com.spring.rentACar.entities.City;
import com.spring.rentACar.repositories.CityRepository;
import com.spring.rentACar.services.abstracts.CityService;
import com.spring.rentACar.services.dtos.requests.city.AddCityRequest;
import com.spring.rentACar.services.dtos.requests.city.UpdateCityRequest;
import com.spring.rentACar.services.dtos.responses.city.GetCityListResponse;
import com.spring.rentACar.services.dtos.responses.city.GetCityResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CityManager implements CityService {

    private final CityRepository cityRepository;

    @Override
    public void add(AddCityRequest addCityRequest) {
        City city = new City();
        city.setName(addCityRequest.getName());
        cityRepository.save(city);
    }

    @Override
    public GetCityResponse getById(int id) {
        City city = cityRepository.findById(id).orElseThrow();
        GetCityResponse getCityResponse = new GetCityResponse();
        getCityResponse.setName(city.getName());
        return getCityResponse;
    }

    @Override
    public List<GetCityListResponse> getAll() {
        List<City> cities = cityRepository.findAll();
        List<GetCityListResponse> getCityListResponses = new ArrayList<>();
        for (City city:cities) {
            GetCityListResponse getCityListResponse = new GetCityListResponse();
            getCityListResponse.setName(city.getName());
            getCityListResponses.add(getCityListResponse);
        }
        return getCityListResponses;
    }

    @Override
    public void update(int id, UpdateCityRequest updateCityRequest) {
        City cityToUpdate = cityRepository.findById(id).orElseThrow();
        cityToUpdate.setName(updateCityRequest.getName());
        cityRepository.save(cityToUpdate);
    }

    @Override
    public void delete(int id) {
        cityRepository.deleteById(id);
    }

    @Override
    public List<GetCityListResponse> getByNameStartingWith(String prefix) {
        List<City> cities = cityRepository.findByNameStartingWith(prefix);
        List<GetCityListResponse> responses = new ArrayList<>();
        for (City city : cities){
            responses.add(new GetCityListResponse(city.getName()));
        }
        return responses;
    }

    @Override
    public List<GetCityListResponse> getByNameNotNull() {
        List<City> cities = cityRepository.findByNameNotNull();
        List<GetCityListResponse> responses = new ArrayList<>();
        for (City city : cities){
            responses.add(new GetCityListResponse(city.getName()));
        }
        return responses;
    }

    @Override
    public List<GetCityListResponse> getByNameEndsWith(String name) {
        return cityRepository.getByNameEndsWith(name);
    }

    @Override
    public List<GetCityListResponse> getNameLengthGreaterThan(int length) {
        return cityRepository.getNameLengthGreaterThan(length);
    }
}
