package com.example.shopproject.service;

import com.example.shopproject.dto.request.CategoryRq;
import com.example.shopproject.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategory();
    void deleteCategory(Integer id);
    void addCategory(CategoryRq categoryRq);
}
