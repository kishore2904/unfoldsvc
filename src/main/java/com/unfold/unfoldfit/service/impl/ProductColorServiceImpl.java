package com.unfold.unfoldfit.service.impl;

import com.unfold.unfoldfit.mapper.ProductColorMapper;
import com.unfold.unfoldfit.model.dto.ProductColorDto;
import com.unfold.unfoldfit.model.entity.ProductColor;
import com.unfold.unfoldfit.repository.ProductColorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ProductColorServiceImpl {

    private  final ProductColorRepository productColorRepository;
    private final ProductColorMapper productColorMapper;

    public ProductColorServiceImpl(ProductColorRepository productColorRepository, ProductColorMapper productColorMapper) {
        this.productColorRepository = productColorRepository;
        this.productColorMapper = productColorMapper;
    }

    public void create(ProductColorDto productColorDto){
        ProductColor productColor = productColorMapper.convertToProductColor(productColorDto);
        productColorRepository.save(productColor);
    }

    public List<ProductColorDto> getAllProductColors(){
        List<ProductColor> productColors = productColorRepository.findAll();
        return productColorMapper.convertToProductColorDto(productColors);
    }

    public ProductColorDto getByColorId(Long productColorId){
        ProductColor productColor = productColorRepository.findById(productColorId).get();
        return productColorMapper.convertToProductColorDto(productColor);
    }

    public void update(Long productColorId, ProductColorDto productColorDto){
        ProductColor productColor = productColorRepository.findById(productColorId).get();
        if(productColor!=null){
            ProductColor updatedProductColor = productColorMapper.convertToProductColor(productColorDto);
            productColorRepository.save(updatedProductColor);
        }
    }

    public void delete(Long productColorId){
        productColorRepository.deleteById(productColorId);
    }
}
