package com.example.demo.service.property;

import com.example.demo.entity.Property;

import java.util.List;

public interface PropertyService {

    List<Property> findAll();

    List<Property> findPropertiesByCategory(int categoryId);

    Property findById(int theId);

    int save(SavePropertyRequest request);

    void deleteById(int theId);
}
