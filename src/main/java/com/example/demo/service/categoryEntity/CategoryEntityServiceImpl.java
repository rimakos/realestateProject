package com.example.demo.service.categoryEntity;

import com.example.demo.dao.CategoryEntityRepository;
import com.example.demo.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryEntityServiceImpl implements CategoryEntityService {

    public CategoryEntityRepository categoryEntityRepository;

    @Autowired
    public CategoryEntityServiceImpl(CategoryEntityRepository theCategoryEntityRepository) {
        categoryEntityRepository = theCategoryEntityRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryEntityRepository.findAll();
    }

    @Override
    public Category findById(int theId) {
        return categoryEntityRepository.findById(theId).orElse(null);
    }

    @Override
    public int save(SaveCategoryRequest request) {
        var dbCategory = categoryEntityRepository.findById(request.getId());
        if (dbCategory.isPresent()) {
            dbCategory.get().setName(request.getName());
            categoryEntityRepository.save(dbCategory.get());
            return dbCategory.get().getId();
        }
        var newCategory = Category.builder()
                .name(request.getName())
                .createdAt(new Date())
                .build();
        categoryEntityRepository.save(newCategory);
        return newCategory.getId();
    }

    @Override
    public void deleteById(int theId) {
        Category categoryEntity = categoryEntityRepository.findById(theId).orElseThrow(() -> new IllegalArgumentException());
        categoryEntityRepository.delete(categoryEntity);
    }
}
