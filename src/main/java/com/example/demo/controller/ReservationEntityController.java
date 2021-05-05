package com.example.demo.controller;


import com.example.demo.entity.ReservationEntity;
import com.example.demo.service.reservationEntity.ReservationEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationEntityController {

    private ReservationEntityService reservationEntityService;

    @Autowired
    public ReservationEntityController
            (ReservationEntityService reservationEntityService) {
        this.reservationEntityService = reservationEntityService;
    }

    @GetMapping("/reservations")
    public List<ReservationEntity> findAll() {
        return reservationEntityService.findAll();
    }

    @GetMapping("/reservations/{reservationId}")
    public ResponseEntity getReservationById(@PathVariable int reservationId) {

        ReservationEntity reservationEntity = reservationEntityService.findById(reservationId);
        if (reservationEntity == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(reservationEntity);
    }

    @PostMapping("/reservations/add")
    public ReservationEntity addReservation(@RequestBody @Valid ReservationEntity reservationEntity) {
        reservationEntityService.save(reservationEntity);

        return reservationEntity;
    }

    @DeleteMapping("/reservations/delete/{id}")
    public String deleteReservation(@PathVariable("id") int id) {
        String result = reservationEntityService.deleteById(id);
        return result;
    }


}
