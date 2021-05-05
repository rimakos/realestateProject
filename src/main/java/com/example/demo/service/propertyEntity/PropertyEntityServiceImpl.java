package com.example.demo.service.propertyEntity;

import com.example.demo.dao.CategoryEntityRepository;
import com.example.demo.dao.PropertyEntityRepository;
import com.example.demo.entity.PropertyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public PropertyEntity save(PropertyEntity propertyEntity) {
        var dbPropertyEntity = propertyEntityRepository.findById(propertyEntity.getId());
        if (dbPropertyEntity.isPresent()) {
            dbPropertyEntity.get().setTitle(propertyEntity.getTitle());
            dbPropertyEntity.get().setPrice(propertyEntity.getPrice());
            dbPropertyEntity.get().setDescription(propertyEntity.getDescription());
            dbPropertyEntity.get().setType(propertyEntity.getType());
            dbPropertyEntity.get().setYearBuild(propertyEntity.getYearBuild());
            dbPropertyEntity.get().setSquareFit(propertyEntity.getSquareFit());
            dbPropertyEntity.get().setBedroom(propertyEntity.getBedroom());
            dbPropertyEntity.get().setBathroom(propertyEntity.getBathroom());
            dbPropertyEntity.get().setBathroom(propertyEntity.getBathroom());
            dbPropertyEntity.get().setPropertyStatus(propertyEntity.getPropertyStatus());
            dbPropertyEntity.get().setLocation(propertyEntity.getLocation());
            dbPropertyEntity.get().setCategoryEntity(propertyEntity.getCategoryEntity());
            dbPropertyEntity.get().setCategoryId(propertyEntity.getCategoryId());
            dbPropertyEntity.get().setCreatedAt(propertyEntity.getCreatedAt());
            dbPropertyEntity.get().setFeatured(propertyEntity.isFeatured());
            propertyEntityRepository.save(dbPropertyEntity.get());
        } else {
            propertyEntity.setCreatedAt(new Date());
            propertyEntityRepository.save(propertyEntity);
        }
        return propertyEntity;
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
