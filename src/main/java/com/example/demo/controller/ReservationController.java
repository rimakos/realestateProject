package com.example.demo.controller;

import com.example.demo.entity.Reservation;
import com.example.demo.service.property.SavePropertyRequest;
import com.example.demo.service.reservation.ReservationService;
import com.example.demo.service.reservation.SaveNewClientReservationDTO;
import com.example.demo.service.reservation.SaveReservationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController{

    private final ReservationService reservationService;

    @Autowired
    public ReservationController (ReservationService reservationService){
        this.reservationService = reservationService;

    }
    @GetMapping
    public List<Reservation> findAll() {
        return reservationService.findAll();
    }
    @PostMapping("/newreservation")
    public int addReservation(@RequestBody @Valid SaveNewClientReservationDTO request) {
        return   reservationService.save(request);
    }}
//    @GetMapping("/{id}")
//    public ResponseEntity getReservation(@PathVariable int id) {
//       Reservation reservation= reservationService.findById(id);
//        if (reservation == null) {
//            return new ResponseEntity(HttpStatus.NOT_FOUND);
//        }
//        return ResponseEntity.ok(reservation);
//    }
//
//    @PostMapping
//    public int save(@RequestBody @Valid SaveReservationRequest request) {
//        return reservationService.save(request);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteReservation(@PathVariable("id") int id) {
//        reservationService.deleteById(id);
//    }
//}

