package com.abhisheksharma.blogapp.blogappbackendapis.services;

import com.abhisheksharma.blogapp.blogappbackendapis.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    List<CategoryDto> getAllCategories();

    CategoryDto getCategoryById(Integer categoryId);

    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    void deleteCategory(Integer categoryId);

}
