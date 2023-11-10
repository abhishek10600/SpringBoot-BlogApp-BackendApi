package com.abhisheksharma.blogapp.blogappbackendapis.controllers;

import com.abhisheksharma.blogapp.blogappbackendapis.payloads.ApiResponse;
import com.abhisheksharma.blogapp.blogappbackendapis.payloads.CategoryDto;
import com.abhisheksharma.blogapp.blogappbackendapis.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/createCategory")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto createdCategory =  this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(createdCategory, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        List<CategoryDto> categoryDtos = this.categoryService.getAllCategories();
        return ResponseEntity.ok(categoryDtos);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer categoryId){
        CategoryDto categoryDto = this.categoryService.getCategoryById(categoryId);
        return ResponseEntity.ok(categoryDto);
    }

    @PutMapping("/update/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer categoryId){
        CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto, categoryId);
        return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer categoryId){
        this.categoryService.deleteCategory(categoryId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Category successfully deleted.", true), HttpStatus.OK);
    }

}
