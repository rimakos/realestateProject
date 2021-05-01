package com.example.demo.service.reservationEntity;

import com.example.demo.entity.PropertyEntity;
import com.example.demo.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationEntityService {
    public List<ReservationEntity> findAll();

    public ReservationEntity findById(int theId);

    public void save(ReservationEntity reservationEntity);

    public void deleteById(int theId);

    List<ReservationEntity> getClientReservations(int clientId);
}
