package com.example.demo.service.propertyEntity;

import com.example.demo.dao.CategoryEntityRepository;
import com.example.demo.dao.PropertyEntityRepository;
import com.example.demo.entity.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
    public List<Property> findAll() {
        return propertyEntityRepository.findAll();
    }

    @Override
    public Property findById(int theId) {
        return propertyEntityRepository.findById(theId).orElse(null);
    }

    @Override
    public int save(SavePropertyRequest request) {
        var dbPropertyEntity = propertyEntityRepository.findById(request.getId());
        if (dbPropertyEntity.isPresent()) {
            dbPropertyEntity.get().setCategoryId(request.getCategoryId());
            dbPropertyEntity.get().setTitle(request.getTitle());
            dbPropertyEntity.get().setPrice(request.getPrice());
            dbPropertyEntity.get().setDescription(request.getDescription());
            dbPropertyEntity.get().setType(request.getType());
            dbPropertyEntity.get().setYearBuild(request.getYearBuild());
            dbPropertyEntity.get().setSquareFit(request.getSquareFit());
            dbPropertyEntity.get().setBedroom(request.getBedroom());
            dbPropertyEntity.get().setPropertyStatus(request.getPropertyStatus());
            dbPropertyEntity.get().setLocation(request.getLocation());
            dbPropertyEntity.get().setFeatured(request.isFeatured());
            propertyEntityRepository.save(dbPropertyEntity.get());
            return dbPropertyEntity.get().getId();
        } else {
            var newProperty = Property.builder()
                    .categoryId(request.getCategoryId())
                    .propertyStatus(request.getPropertyStatus())
                    .bathroom(request.getBathroom())
                    .yearBuild(request.getYearBuild())
                    .location(request.getLocation())
                    .price(request.getPrice())
                    .description(request.getDescription())
                    .bedroom(request.getBedroom())
                    .title(request.getTitle())
                    .type(request.getType())
                    .Featured(request.isFeatured())
                    .squareFit(request.getSquareFit())
                    .createdAt(new Date())
                    .build();

            propertyEntityRepository.save(newProperty);
            return newProperty.getId();
        }
    }


    @Override
    public void deleteById(int theId) {
        Property property = propertyEntityRepository.findById(theId).orElseThrow(() -> new IllegalArgumentException());
        propertyEntityRepository.delete(property);
    }
//    @Override
//    public List<Property> getCategoryProperties(int categoryId) {
//        return categoryEntityRepository.getCategoryProperties(categoryId);
//    }

}
