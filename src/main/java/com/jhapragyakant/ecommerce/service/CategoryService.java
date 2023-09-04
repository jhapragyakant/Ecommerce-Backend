package com.jhapragyakant.ecommerce.service;

import com.jhapragyakant.ecommerce.payload.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    Boolean doesCategoryExists(String categoryName);
    CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId);
    void deleteCategory(Long categoryId);
    List<CategoryDto> getAllCategory();
    CategoryDto getCategoryById(Long categoryId);
}
