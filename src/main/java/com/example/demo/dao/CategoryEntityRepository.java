package com.example.demo.dao;

import com.example.demo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryEntityRepository extends JpaRepository<Category, Integer> {

}
