package com.example.demo.service.categoryEntity;

import com.example.demo.entity.Category;

import java.util.List;

public interface CategoryEntityService {
    public List<Category> findAll();

    public Category findById(int theId);

    public int save(SaveCategoryRequest request);

    public void deleteById(int theId);
}
