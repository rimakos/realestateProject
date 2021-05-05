package com.example.demo.controller;


import com.example.demo.entity.ClientEntity;
import com.example.demo.entity.ReservationEntity;
import com.example.demo.service.clientEntity.ClientEntityService;
import com.example.demo.service.reservationEntity.ReservationEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ClientEntityController {

    private ClientEntityService clientEntityService;
    private ReservationEntityService reservationEntityService;

    @Autowired
    public ClientEntityController
            (ClientEntityService clientEntityService, ReservationEntityService reservationEntityService) {
        this.clientEntityService = clientEntityService;
        this.reservationEntityService = reservationEntityService;
    }

    @GetMapping("/clients")
    public List<ClientEntity> findAll() {
        return clientEntityService.findAll();
    }

    @GetMapping("/clients/{clientId}")
    public ResponseEntity getClient(@PathVariable int clientId) {

        ClientEntity clientEntity = clientEntityService.findById(clientId);
        if (clientEntity == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(clientEntity);

    }


    @GetMapping("/clients/reservations/{clientId}")
    public List<ReservationEntity> getClientReservations(@PathVariable int clientId) {
        return reservationEntityService.getClientReservations(clientId);
    }

    @PostMapping("/clients/add")
    public ClientEntity addClient(@RequestBody @Valid ClientEntity clientEntity) {
        clientEntityService.save(clientEntity);

        return clientEntity;
    }

    @DeleteMapping("/clients/delete/{id}")
    public String deleteClient(@PathVariable("id") int id) {
        String result = clientEntityService.deleteById(id);
        return result;
    }


}
