package com.example.shopproject.service.Impl;

import com.example.shopproject.dto.request.CategoryRq;
import com.example.shopproject.model.Category;
import com.example.shopproject.repository.CategoryRepository;
import com.example.shopproject.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void addCategory(CategoryRq categoryRq) {
        Category category = new Category();
        category.setName(categoryRq.getName());
        categoryRepository.saveAndFlush(category);
    }
}
