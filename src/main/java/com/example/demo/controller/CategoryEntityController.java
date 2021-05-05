package com.example.demo.controller;


import com.example.demo.entity.CategoryEntity;

import com.example.demo.service.categoryEntity.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryEntityController {

    private CategoryEntityService categoryEntityService;

    @Autowired
    public CategoryEntityController
            (CategoryEntityService categoryEntityService) {
        this.categoryEntityService = categoryEntityService;
    }

    @GetMapping("/categories")
    public List<CategoryEntity> findAll() {
        return categoryEntityService.findAll();
    }

    @GetMapping("/categories/{categoryId}")
    public ResponseEntity getCategory(@PathVariable int categoryId) {

        CategoryEntity categoryEntity = categoryEntityService.findById(categoryId);
        if (categoryEntity == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(categoryEntity);

    }

//    @GetMapping("/categories/properties/{categoryId}")
//    public List<PropertyEntity> getCategoryProperties(@PathVariable int categoryId) {
//        return propertyEntityService.getCategoryProperties(categoryId);
//    }

    @PostMapping("/categories/add")
    public CategoryEntity addCategory(@RequestBody @Valid CategoryEntity categoryEntity) {
        categoryEntityService.save(categoryEntity);

        return categoryEntity;
    }

    @DeleteMapping("/categories/delete/{id}")
    public String deleteCategory(@PathVariable("id") int id) {
        String result = categoryEntityService.deleteById(id);
        return result;
    }


}
