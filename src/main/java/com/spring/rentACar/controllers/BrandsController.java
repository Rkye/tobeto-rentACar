package com.spring.rentACar.controllers;

import com.spring.rentACar.dtos.requests.brand.AddBrandRequest;
import com.spring.rentACar.dtos.requests.brand.UpdateBrandRequest;
import com.spring.rentACar.dtos.responses.brand.GetBrandListResponse;
import com.spring.rentACar.dtos.responses.brand.GetBrandResponse;
import com.spring.rentACar.entities.Brand;
import com.spring.rentACar.repositories.BrandRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandsController {

    private final BrandRepository brandRepository;

    public BrandsController(BrandRepository brandRepository){
        this.brandRepository = brandRepository;
    }

    @GetMapping
    public List<GetBrandListResponse> getAll(){
        List<Brand> brands = brandRepository.findAll();
        List<GetBrandListResponse> getBrandListResponses = new ArrayList<>();
        for (Brand brand:brands) {
            GetBrandListResponse getBrandListResponse = new GetBrandListResponse();
            getBrandListResponse.setName(brand.getName());
            getBrandListResponses.add(getBrandListResponse);
        }
       return getBrandListResponses;
    }

    @GetMapping("{id}")
    public GetBrandResponse getById(@PathVariable int id){
        Brand brand = brandRepository.findById(id).orElseThrow();
        GetBrandResponse getBrandResponse = new GetBrandResponse();
        getBrandResponse.setName(brand.getName());
        return getBrandResponse;
    }
    @PostMapping
    public void add(@RequestBody AddBrandRequest addBrandRequest){
        Brand brand = new Brand();
        brand.setName(addBrandRequest.getName());
        brandRepository.save(brand);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateBrandRequest updateBrandRequest){
        Brand brandToUpdate = brandRepository.findById(id).orElseThrow();
            brandToUpdate.setName(updateBrandRequest.getName());
        brandRepository.save(brandToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        //Brand branToDelete = brandRepository.findById(id).orElseThrow();
        //brandRepository.delete(branToDelete);
        brandRepository.deleteById(id);
    }
}