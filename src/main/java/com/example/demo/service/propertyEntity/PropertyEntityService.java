package com.example.demo.service.propertyEntity;

import com.example.demo.entity.PropertyEntity;

import java.util.List;

public interface PropertyEntityService {

    public List<PropertyEntity> findAll();

    public PropertyEntity findById(int theId);

    public PropertyEntity save(PropertyEntity propertyEntity);

    public String deleteById(int theId);

//    List<PropertyEntity> getCategoryProperties(int categoryId);
}
