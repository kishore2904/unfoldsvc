package com.unfold.unfoldfit.controller;

import com.unfold.unfoldfit.model.dto.CategoryDto;
import com.unfold.unfoldfit.service.impl.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/categories")
    ResponseEntity<Void> saveCategories(@RequestBody CategoryDto categoryDto){
        categoryServiceImpl.createCategories(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping(value = "/categories/{categoryId}")
    ResponseEntity<Void> updateCategory(@PathVariable Integer categoryId, @RequestBody CategoryDto categoryDto){

        categoryServiceImpl.updateCategory(categoryId,categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(value = "/categories/{deleteId}")
    ResponseEntity<Void> deleteCategoryWithProduct(@PathVariable Integer categoryId){

        categoryServiceImpl.deleteCategoryWithProduct(categoryId);
        return ResponseEntity.noContent().build();

    }
}
