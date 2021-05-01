package com.example.demo.dao;

import com.example.demo.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientEntityRepository extends JpaRepository<ClientEntity, Integer> {
}
