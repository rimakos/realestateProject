package com.example.demo.dao;

import com.example.demo.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyEntityRepository extends JpaRepository<Property, Integer> {

}
