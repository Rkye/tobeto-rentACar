package com.spring.rentACar.controllers;

import com.spring.rentACar.services.abstracts.BrandService;
import com.spring.rentACar.services.dtos.requests.brand.AddBrandRequest;
import com.spring.rentACar.services.dtos.requests.brand.UpdateBrandRequest;
import com.spring.rentACar.services.dtos.responses.brand.GetBrandListResponse;
import com.spring.rentACar.services.dtos.responses.brand.GetBrandResponse;
import com.spring.rentACar.entities.Brand;
import com.spring.rentACar.repositories.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/brands")
@AllArgsConstructor
public class BrandsController {

    private final BrandService brandService;

    @GetMapping
    public List<GetBrandListResponse> getAll(){
        return brandService.getAll();
    }

    @GetMapping("{id}")
    public GetBrandResponse getById(@PathVariable int id){
        return brandService.getById(id);
    }
    @PostMapping
    public void add(@RequestBody AddBrandRequest addBrandRequest){
        brandService.add(addBrandRequest);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateBrandRequest updateBrandRequest){
        brandService.update(id,updateBrandRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        //Brand branToDelete = brandRepository.findById(id).orElseThrow();
        //brandRepository.delete(branToDelete);
        brandService.delete(id);
    }
}