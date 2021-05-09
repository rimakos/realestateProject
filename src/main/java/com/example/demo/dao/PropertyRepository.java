package com.example.demo.dao;

import com.example.demo.entity.Category;
import com.example.demo.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Integer> {

    @Query("select c from Property c where c.categoryId=:id")
    List<Property> findPropertiesByCategory(@Param("id")int id);

}
