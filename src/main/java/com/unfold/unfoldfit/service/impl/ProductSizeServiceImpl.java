package com.unfold.unfoldfit.service.impl;

import com.unfold.unfoldfit.mapper.ProductSizeMapper;
import com.unfold.unfoldfit.model.dto.ProductSizeDto;
import com.unfold.unfoldfit.model.entity.ProductSize;
import com.unfold.unfoldfit.repository.ProductSizeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ProductSizeServiceImpl {

    private  final ProductSizeRepository productSizeRepository;
    private final ProductSizeMapper productSizeMapper;

    public ProductSizeServiceImpl(ProductSizeRepository productSizeRepository, ProductSizeMapper productSizeMapper) {
        this.productSizeRepository = productSizeRepository;
        this.productSizeMapper = productSizeMapper;
    }


    public void create(ProductSizeDto productSizeDto){
        ProductSize productSize = productSizeMapper.convertToProductSize(productSizeDto);
        productSizeRepository.save(productSize);
    }

    public List<ProductSizeDto> getAllProductSizes(){
        List<ProductSize> productSizes = productSizeRepository.findAll();
        return productSizeMapper.convertToProductSizeDto(productSizes);
    }

    public ProductSizeDto getByProductSizeId(Long productSizeId){
        ProductSize productSize = productSizeRepository.findById(productSizeId).get();
        return productSizeMapper.convertToProductSizeDto(productSize);
    }

    public void update(Long productSizeId, ProductSizeDto productSizeDto){
        ProductSize productSize = productSizeRepository.findById(productSizeId).get();
        if(productSize!=null){
            ProductSize updatedProductSize = productSizeMapper.convertToProductSize(productSizeDto);
            productSizeRepository.save(updatedProductSize);
        }
    }

    public void delete(Long productColorId){

        productSizeRepository.deleteById(productColorId);
    }
}
