package com.example.demo.service.category;

import com.example.demo.entity.Category;

import java.util.List;

public interface CategoryService {
     List<Category> findAll();

     Category findById(int theId);

     int save(SaveCategoryRequest request);

     void deleteById(int theId);
}
