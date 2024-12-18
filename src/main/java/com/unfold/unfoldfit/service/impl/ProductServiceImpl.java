package com.unfold.unfoldfit.service.impl;

import com.unfold.unfoldfit.mapper.ProductMapper;
import com.unfold.unfoldfit.model.dto.ProductDto;
import com.unfold.unfoldfit.model.entity.Category;
import com.unfold.unfoldfit.model.entity.Product;
import com.unfold.unfoldfit.repository.CategoryRepository;
import com.unfold.unfoldfit.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productMapper = productMapper;
    }

    public ProductDto getProductBasedOnCategoryIdAndProductId
            (Integer categoryId,Integer productId){

        Product product = productRepository.findProductByCategoryIdAndProductId(categoryId,productId);
        return productMapper.convertToProductDto(product);

    }

    public void createProductsUnderCategory(Integer categoryId,List<ProductDto> productDtos){

        Category category = validateCategory(categoryId);

        List<Product> productList = productMapper.convertToProduct(productDtos);

        category.setProducts(productList);

        categoryRepository.save(category);

    }

    public void updateProductUnderCategory(Integer categoryId,ProductDto productDto){
        Category category = validateCategory(categoryId);
        if(category!=null){
            Product product = productMapper.convertToProduct(productDto);
            productRepository.updateProductBasedOnCategoryAndProductId(categoryId,product.getProductId(),
                    product.getProductName(),product.getProductDescription(),product.getPrice(),
                    product.getStockQuantity(),product.getImageUrl());
        }
    }

    public void deleteProductByCategoryAndProductId(Integer categoryId,Integer productId){

        productRepository.deleteProductByCategoryAndProductId(categoryId,productId);

    }

    private Category validateCategory(Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new RuntimeException("Category Doesn't exist")
        );
        return category;
    }
}
