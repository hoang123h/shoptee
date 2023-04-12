package com.shoptee.shoptee.service;

import com.shoptee.shoptee.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategory();
    Category createCategory(Category category);
    Category getCategoryById(Integer id);
    void deleteById(Integer id);
    void updateCategory(Integer id, Category category);
}
