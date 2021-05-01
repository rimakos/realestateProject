package com.example.demo.dao;

import com.example.demo.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationEntityRepository extends JpaRepository<ReservationEntity, Integer> {
}
