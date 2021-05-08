package com.example.demo.controller;


import com.example.demo.entity.Category;

import com.example.demo.service.categoryEntity.CategoryEntityService;
import com.example.demo.service.categoryEntity.SaveCategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryEntityController {

    private CategoryEntityService categoryEntityService;

    @Autowired
    public CategoryEntityController
            (CategoryEntityService categoryEntityService) {
        this.categoryEntityService = categoryEntityService;
    }

    @GetMapping
    public List<Category> findAll() {
        return categoryEntityService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getCategory(@PathVariable int id) {
        Category category = categoryEntityService.findById(id);
        if (category == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(category);
    }

    @PostMapping
    public int save(@RequestBody @Valid SaveCategoryRequest request) {
        return categoryEntityService.save(request);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") int id) {
        categoryEntityService.deleteById(id);
    }
}
