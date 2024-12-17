package com.unfold.unfoldfit.controller;

import com.unfold.unfoldfit.model.dto.CategoryDto;
import com.unfold.unfoldfit.service.impl.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/rest/unfold")
public class CategoriesController {

    private final CategoryServiceImpl categoryServiceImpl;

    public CategoriesController(CategoryServiceImpl categoryServiceImpl) {
        this.categoryServiceImpl = categoryServiceImpl;
    }

    @GetMapping(value="/allCategories")
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        return ResponseEntity.ok(categoryServiceImpl.findAllCategories());
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<List<CategoryDto>> findCategoryAndProductsByCategoryId(@PathVariable Integer categoryId){
        return ResponseEntity.ok(categoryServiceImpl.findCategoryAndProductsByCategoryId(categoryId));
    }
}
