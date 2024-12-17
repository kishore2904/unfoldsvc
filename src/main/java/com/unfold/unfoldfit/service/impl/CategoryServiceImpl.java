package com.unfold.unfoldfit.service.impl;

import com.unfold.unfoldfit.mapper.CategoryMapper;
import com.unfold.unfoldfit.model.dto.CategoryDto;
import com.unfold.unfoldfit.model.entity.Category;
import com.unfold.unfoldfit.repository.CategoryRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public List<CategoryDto> findAllCategories(){

        List<Category> categoryList = categoryRepository.findAll();
        return categoryMapper.convertToCategoryDto(categoryList);

    }

    public List<CategoryDto> findCategoryAndProductsByCategoryId(Integer categoryId){

        List<Category> categoryList = categoryRepository.findCategoryAndProductsByCategoryId(categoryId);
        return categoryMapper.convertToCategoryDtoWithProduct(categoryList);

    }
}
