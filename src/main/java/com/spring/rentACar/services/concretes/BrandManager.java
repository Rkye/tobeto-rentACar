package com.spring.rentACar.services.concretes;

import com.spring.rentACar.entities.Brand;
import com.spring.rentACar.repositories.BrandRepository;
import com.spring.rentACar.services.abstracts.BrandService;
import com.spring.rentACar.services.dtos.requests.brand.AddBrandRequest;
import com.spring.rentACar.services.dtos.requests.brand.UpdateBrandRequest;
import com.spring.rentACar.services.dtos.responses.brand.GetBrandListResponse;
import com.spring.rentACar.services.dtos.responses.brand.GetBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;



    @Override
    public void add(AddBrandRequest addBrandRequest) {

        if(brandRepository.existsByName(addBrandRequest.getName().trim()))
            throw new RuntimeException("Aynı isimle iki marka eklenemez.");

        Brand brand = new Brand();
        brand.setName(addBrandRequest.getName());
        brandRepository.save(brand);
    }

    @Override
    public GetBrandResponse getById(int id) {
        Brand brand = brandRepository.findById(id).orElseThrow();
        GetBrandResponse getBrandResponse = new GetBrandResponse();
        getBrandResponse.setName(brand.getName());
        return getBrandResponse;
    }

    @Override
    public List<GetBrandListResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetBrandListResponse> getBrandListResponses = new ArrayList<>();
        for (Brand brand:brands) {
            GetBrandListResponse getBrandListResponse = new GetBrandListResponse();
            getBrandListResponse.setName(brand.getName());
            getBrandListResponses.add(getBrandListResponse);
        }
        return getBrandListResponses;
    }

    @Override
    public void update(int id, UpdateBrandRequest updateBrandRequest) {
        Brand brandToUpdate = brandRepository.findById(id).orElseThrow();
        brandToUpdate.setName(updateBrandRequest.getName());
        brandRepository.save(brandToUpdate);
    }

    @Override
    public void delete(int id) {
        brandRepository.deleteById(id);
    }

    @Override
    public List<GetBrandListResponse> getByName(String name) {
        List<Brand> brandList = brandRepository.findByNameLike("%" + name + "%");
        List<GetBrandListResponse> responses = new ArrayList<>();
        for (Brand brand : brandList){
            responses.add(new GetBrandListResponse(brand.getName()));
        }
        return responses;
    }

    @Override
    public List<GetBrandListResponse> getOrderByName(String name) {
        List<Brand> brands = brandRepository.findByNameOrderByNameDesc(name);
        List<GetBrandListResponse> responses = new ArrayList<>();
        for (Brand brand : brands){
            responses.add(new GetBrandListResponse(brand.getName()));
        }
        return responses;
    }

    @Override
    public List<GetBrandListResponse> getByNameOrderBy() {
        return brandRepository.getByNameOrderBy();
    }

    @Override
    public List<GetBrandListResponse> getByNameLike(String name) {
        return brandRepository.getByNameLike(name);
    }


}
