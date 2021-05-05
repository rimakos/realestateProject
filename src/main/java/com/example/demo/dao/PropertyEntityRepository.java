package com.example.demo.dao;

import com.example.demo.entity.PropertyEntity;
import com.example.demo.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PropertyEntityRepository extends JpaRepository<PropertyEntity, Integer> {

    @Query("select r from ReservationEntity r where r.clientEntity.id=:id")
    List<ReservationEntity> getClientReservations(@Param("id")int id);
}
