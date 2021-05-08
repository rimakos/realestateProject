package com.example.demo.controller;


import com.example.demo.entity.Property;
import com.example.demo.service.categoryEntity.CategoryEntityService;
import com.example.demo.service.propertyEntity.PropertyEntityService;
import com.example.demo.service.propertyEntity.SavePropertyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PropertyEntityController {

    private PropertyEntityService propertyEntityService;
    private CategoryEntityService categoryEntityService;

    @Autowired
    public PropertyEntityController
            (PropertyEntityService propertyEntityService,
             CategoryEntityService categoryEntityService) {
        this.propertyEntityService = propertyEntityService;
        this.categoryEntityService = categoryEntityService;
    }

    @GetMapping("/properties")
    public List<Property> findAll() {
        return propertyEntityService.findAll();
    }

    @GetMapping("/properties/{propertyId}")
    public ResponseEntity getPropertyById(@PathVariable int propertyId) {

        Property property = propertyEntityService.findById(propertyId);
        if (property == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(property);

    }


    @PostMapping("/properties/add")
    public int addProperty(@RequestBody @Valid SavePropertyRequest request) {
      return   propertyEntityService.save(request);

    }
}
