package com.example.demo.dao;


import com.example.demo.entity.Property;
import com.example.demo.enumerations.PropertyStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Integer> {

    @Query("select c from Property c where c.categoryId=:id")
    List<Property> findPropertiesByCategory(@Param("id")int id);

    @Query("select s from Property s where s.propertyStatus=:status")
    List<Property> findPropertiesByStatus (@Param("status")PropertyStatus status);

    @Query("select p from Property  p where  p.Featured = true")
    List<Property>findByFeatured();

    @Query("select p from Property p where p.categoryId=:id and p.propertyStatus=:status")
    List<Property>searchBox(@Param("id") int id, @Param("status")PropertyStatus status) ;

}
