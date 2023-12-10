package com.spring.rentACar.controllers;

import com.spring.rentACar.services.abstracts.BrandService;
import com.spring.rentACar.services.dtos.requests.brand.AddBrandRequest;
import com.spring.rentACar.services.dtos.requests.brand.UpdateBrandRequest;
import com.spring.rentACar.services.dtos.responses.brand.GetBrandListResponse;
import com.spring.rentACar.services.dtos.responses.brand.GetBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("getByName")
    public List<GetBrandListResponse> getByName(@RequestParam String name){
        return brandService.getByName(name);
    }

    @GetMapping("getOrderByName")
    public List<GetBrandListResponse> getOrderByName(String name){
        return brandService.getOrderByName(name);
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
        //Brand brandToDelete = brandRepository.findById(id).orElseThrow();
        //brandRepository.delete(brandToDelete);
        brandService.delete(id);
    }

    @GetMapping("getByNameOrderByJPQL")
    public List<GetBrandListResponse> getByNameOrderBy(){
        return brandService.getByNameOrderBy();
    }

    @GetMapping("getByNameLikeJPQL")
    public List<GetBrandListResponse> getByNameLikeJPQL(String name){
        return brandService.getByNameLike(name);
    }
}