package com.example.demo.controller;


import com.example.demo.entity.Category;

import com.example.demo.service.category.CategoryService;
import com.example.demo.service.category.SaveCategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController
            (CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getCategory(@PathVariable int id) {
        Category category = categoryService.findById(id);
        if (category == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(category);
    }

    @PostMapping
    public int save(@RequestBody @Valid SaveCategoryRequest request) {
        return categoryService.save(request);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") int id) {
        categoryService.deleteById(id);
    }
}
