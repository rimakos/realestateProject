package com.example.demo.dao;

import com.example.demo.entity.CategoryEntity;
import com.example.demo.entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryEntityRepository extends JpaRepository<CategoryEntity, Integer> {
//    @Query("select c from CategoryEntity  c where c.P")
//    List<PropertyEntity> getCategoryProperties(int categoryId);
}
