package com.spring.rentACar.controllers;

import com.spring.rentACar.entities.Brand;
import com.spring.rentACar.repositories.BrandRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandsController {

    private final BrandRepository brandRepository;

    public BrandsController(BrandRepository brandRepository){
        this.brandRepository = brandRepository;
    }

    @GetMapping
    public List<Brand> getAll(){
       return brandRepository.findAll();
    }

    @GetMapping("{id}")
    public Brand getById(@PathVariable int id){
        return brandRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void add(@RequestBody Brand brand){
        brandRepository.save(brand);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Brand brand){
        Brand brandToUpdate = brandRepository.findById(id).orElseThrow();
            brandToUpdate.setName(brand.getName());
            brandToUpdate.setCars(brand.getCars());
        brandRepository.save(brandToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        //Brand branToDelete = brandRepository.findById(id).orElseThrow();
        //brandRepository.delete(branToDelete);
        brandRepository.deleteById(id);
    }
}