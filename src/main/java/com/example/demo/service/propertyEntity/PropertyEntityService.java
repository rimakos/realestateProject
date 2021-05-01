package com.example.demo.service.propertyEntity;

import com.example.demo.entity.PropertyEntity;

import java.util.List;

public interface PropertyEntityService {
    public List<PropertyEntity> findAll();

    public PropertyEntity findById(int theId);

    public void save(PropertyEntity propertyEntity);

    public void deleteById(int theId);

}
