package com.example.demo.service.category;

import com.example.demo.dao.CategoryRepository;
import com.example.demo.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    public CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository theCategoryRepository) {
        categoryRepository = theCategoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int theId) {
        return categoryRepository.findById(theId).orElse(null);
    }

    @Override
    public int save(SaveCategoryRequest request) {
        var dbCategory = categoryRepository.findById(request.getId());
        if (dbCategory.isPresent()) {
            dbCategory.get().setName(request.getName());
            categoryRepository.save(dbCategory.get());
            return dbCategory.get().getId();
        }
        var newCategory = Category.builder()
                .name(request.getName())
                .createdAt(new Date())
                .build();
        categoryRepository.save(newCategory);
        return newCategory.getId();
    }

    @Override
    public void deleteById(int theId) {
        Category categoryEntity = categoryRepository.findById(theId).orElseThrow(() -> new IllegalArgumentException());
        categoryRepository.delete(categoryEntity);
    }
}
