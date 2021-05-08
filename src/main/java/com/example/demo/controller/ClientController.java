package com.example.demo.controller;


import com.example.demo.entity.Client;
import com.example.demo.service.client.ClientService;
import com.example.demo.service.client.SaveClientRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/{clientId}")
    public ResponseEntity getClient(@PathVariable int clientId) {

        Client client = clientService.findById(clientId);
        if (client == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(client);

    }

    @PostMapping
    public int addClient(@RequestBody SaveClientRequest request) {
        return clientService.save(request);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable("id") int id) {
        clientService.deleteById(id);
    }
}
