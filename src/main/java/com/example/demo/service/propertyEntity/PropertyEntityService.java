package com.example.demo.service.propertyEntity;

import com.example.demo.entity.Property;

import java.util.List;

public interface PropertyEntityService {

    public List<Property> findAll();

    public Property findById(int theId);

    public int save(SavePropertyRequest request);

    public void deleteById(int theId);

//    List<Property> getCategoryProperties(int categoryId);
}
