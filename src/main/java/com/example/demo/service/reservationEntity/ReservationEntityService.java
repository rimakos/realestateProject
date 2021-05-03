package com.example.demo.service.reservationEntity;

import com.example.demo.entity.ReservationEntity;

import java.util.List;

public interface ReservationEntityService {
    public List<ReservationEntity> findAll();

    public ReservationEntity findById(int theId);

    public void save(ReservationEntity reservationEntity);

    public String deleteById(int theId);

    List<ReservationEntity> getClientReservations(int clientId);
}
