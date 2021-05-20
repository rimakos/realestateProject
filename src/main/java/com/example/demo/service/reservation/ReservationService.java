package com.example.demo.service.reservation;

import com.example.demo.entity.Reservation;
import com.example.demo.service.property.SavePropertyRequest;

import java.util.List;

public interface ReservationService {
    List<Reservation> findAll();

    int save(SaveNewClientReservationDTO request);


    Reservation findById(int theId);

    void deleteById(int theId);
}
