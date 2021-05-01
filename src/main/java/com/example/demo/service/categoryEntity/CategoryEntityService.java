package com.example.demo.service.categoryEntity;

import com.example.demo.entity.CategoryEntity;

import java.util.List;

public interface CategoryEntityService {
    public List<CategoryEntity> findAll();

    public CategoryEntity findById(int theId);

    public void save(CategoryEntity categoryEntity);

    public String deleteById(int theId);
}
