package com.example.demo.service.property;

import com.example.demo.dao.CategoryRepository;
import com.example.demo.dao.PropertyRepository;
import com.example.demo.entity.Property;
import com.example.demo.enumerations.PropertyStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {
    private PropertyRepository propertyRepository;
    private CategoryRepository categoryRepository;


    @Autowired
    public PropertyServiceImpl
            (PropertyRepository thePropertyRepository, CategoryRepository theCategoryRepository) {
        propertyRepository = thePropertyRepository;
        categoryRepository = theCategoryRepository;
    }

    @Override
    public List<Property> findAll() {
        return propertyRepository.findAll();
    }

    @Override
    public List<Property> findPropertiesByCategory(int categoryId) {
        return propertyRepository.findPropertiesByCategory(categoryId);
    }

    @Override
    public List<Property> findPropertiesByStatus(PropertyStatus status) {
        return propertyRepository.findPropertiesByStatus(status);
    }

    @Override
    public Property findById(int theId) {
        return propertyRepository.findById(theId).orElse(null);
    }

    @Override
    public int save(SavePropertyRequest request) {
        var dbPropertyEntity = propertyRepository.findById(request.getId());
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
            dbPropertyEntity.get().setPhoto(request.getPhoto());

            propertyRepository.save(dbPropertyEntity.get());
            return dbPropertyEntity.get().getId();
        }
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
                .photo(request.getPhoto())
                .createdAt(new Date())
                .build();

        propertyRepository.save(newProperty);
        return newProperty.getId();
    }

    @Override
    public void deleteById(int theId) {
        Property property = propertyRepository.findById(theId).orElseThrow(() -> new IllegalArgumentException());
        propertyRepository.delete(property);
    }

}
