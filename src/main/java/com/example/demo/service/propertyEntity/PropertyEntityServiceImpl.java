package com.example.demo.service.propertyEntity;

import com.example.demo.dao.CategoryEntityRepository;
import com.example.demo.dao.PropertyEntityRepository;
import com.example.demo.entity.CategoryEntity;
import com.example.demo.entity.PropertyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyEntityServiceImpl implements PropertyEntityService {
    private PropertyEntityRepository propertyEntityRepository;
    private CategoryEntityRepository categoryEntityRepository;


    @Autowired
    public PropertyEntityServiceImpl
            (PropertyEntityRepository thePropertyEntityRepository, CategoryEntityRepository theCategoryEntityRepository) {
        propertyEntityRepository = thePropertyEntityRepository;
        categoryEntityRepository = theCategoryEntityRepository;
    }

    @Override
    public List<PropertyEntity> findAll() {
        return propertyEntityRepository.findAll();
    }

    @Override
    public PropertyEntity findById(int theId) {
        return propertyEntityRepository.findById(theId).orElse(null);
    }

    @Override
    public void save(PropertyEntity propertyEntity) {
        propertyEntityRepository.save(propertyEntity);

    }

    @Override
    public String deleteById(int theId) {
        Optional<PropertyEntity> propertyEntity = propertyEntityRepository.findById(theId);
        if (propertyEntity.isPresent()) {
            propertyEntityRepository.deleteById(theId);
            return "The Property with id " + theId + " is deleted";
        } else {
            return "The id " + theId + " you enter to delete does not exist";
        }
    }
//    @Override
//    public List<PropertyEntity> getCategoryProperties(int categoryId) {
//        return categoryEntityRepository.getCategoryProperties(categoryId);
//    }

}
