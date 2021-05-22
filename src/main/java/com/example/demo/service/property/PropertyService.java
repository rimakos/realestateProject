package com.example.demo.service.property;

import com.example.demo.entity.Property;
import com.example.demo.enumerations.PropertyStatus;

import java.util.List;

public interface PropertyService {

    List<Property> findAll();

    List<Property> findPropertiesByCategory(int categoryId);

    List<Property> findPropertiesByStatus(PropertyStatus status);

    Property findById(int theId);

    int save(SavePropertyRequest request);

    void deleteById(int theId);

    List<Property> findByFeatured();

    List<Property> searchBox(int id, PropertyStatus propertyStatus);

}
