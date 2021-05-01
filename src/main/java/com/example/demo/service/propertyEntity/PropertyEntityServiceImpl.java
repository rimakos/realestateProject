package com.example.demo.service.propertyEntity;

import com.example.demo.dao.CategoryEntityRepository;
import com.example.demo.dao.PropertyEntityRepository;
import com.example.demo.entity.PropertyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyEntityServiceImpl implements PropertyEntityService{
private PropertyEntityRepository propertyEntityRepository;
private CategoryEntityRepository categoryEntityRepository;


    @Autowired
    public PropertyEntityServiceImpl
            (PropertyEntityRepository thePropertyEntityRepository,CategoryEntityRepository theCategoryEntityRepository){
        propertyEntityRepository=thePropertyEntityRepository;
        categoryEntityRepository=theCategoryEntityRepository;
    }

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

//    @Override
//    public List<PropertyEntity> getCategoryProperties(int categoryId) {
//        return categoryEntityRepository.getCategoryProperties(categoryId);
//    }
}
