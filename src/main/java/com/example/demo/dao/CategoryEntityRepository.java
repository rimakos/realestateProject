package com.example.demo.dao;

import com.example.demo.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryEntityRepository extends JpaRepository<CategoryEntity, Integer> {

}
