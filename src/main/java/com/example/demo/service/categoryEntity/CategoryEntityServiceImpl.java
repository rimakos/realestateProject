package com.example.demo.service.categoryEntity;

import com.example.demo.dao.CategoryEntityRepository;
import com.example.demo.entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<CategoryEntity> findAll() {
        return categoryEntityRepository.findAll();
    }

    @Override
    public CategoryEntity findById(int theId) {
        return categoryEntityRepository.findById(theId).orElse(null);
    }

    @Override
    public void save(CategoryEntity theCategoryEntity) {
        categoryEntityRepository.save(theCategoryEntity);

    }

    @Override
    public String deleteById(int theId) {
        Optional<CategoryEntity> categoryEntity = categoryEntityRepository.findById(theId);
        if (categoryEntity.isPresent()) {
            categoryEntityRepository.deleteById(theId);
            return "The Category with id " + theId + " is deleted";
        } else {
            return "The id " + theId + " you enter to delete does not exist";
        }
    }
}
