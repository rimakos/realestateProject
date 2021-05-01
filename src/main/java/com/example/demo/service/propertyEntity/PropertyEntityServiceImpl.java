package com.example.demo.service.propertyEntity;

import com.example.demo.entity.PropertyEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyEntityServiceImpl implements PropertyEntityService{

    @Override
    public List<PropertyEntity> findAll() {
        return null;
    }

    @Override
    public PropertyEntity findById(int theId) {
        return null;
    }

    @Override
    public void save(PropertyEntity propertyEntity) {

    }

    @Override
    public void deleteById(int theId) {

    }
}
