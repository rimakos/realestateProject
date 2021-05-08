package com.example.demo.controller;


import com.example.demo.entity.Property;
import com.example.demo.service.category.CategoryService;
import com.example.demo.service.property.PropertyService;
import com.example.demo.service.property.SavePropertyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    private PropertyService propertyService;
    private CategoryService categoryService;

    @Autowired
    public PropertyController
            (PropertyService propertyService,
             CategoryService categoryService) {
        this.propertyService = propertyService;
        this.categoryService = categoryService;
    }

    @GetMapping("/properties")
    public List<Property> findAll() {
        return propertyService.findAll();
    }

    @GetMapping("/properties/{propertyId}")
    public ResponseEntity getPropertyById(@PathVariable int propertyId) {

        Property property = propertyService.findById(propertyId);
        if (property == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(property);

    }


    @PostMapping("/properties/add")
    public int addProperty(@RequestBody @Valid SavePropertyRequest request) {
      return   propertyService.save(request);

    }
}
