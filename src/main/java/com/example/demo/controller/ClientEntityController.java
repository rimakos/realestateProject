package com.example.demo.controller;


import com.example.demo.entity.Client;
import com.example.demo.service.clientEntity.ClientEntityService;
import com.example.demo.service.clientEntity.SaveCLientRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientEntityController {

    private ClientEntityService clientEntityService;

    @Autowired
    public ClientEntityController(ClientEntityService clientEntityService) {
        this.clientEntityService = clientEntityService;
    }

    @GetMapping("/")
    public List<Client> findAll() {
        return clientEntityService.findAll();
    }

    @GetMapping("/{clientId}")
    public ResponseEntity getClient(@PathVariable int clientId) {

        Client client = clientEntityService.findById(clientId);
        if (client == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(client);

    }


    @PostMapping("/clients")
    public int addClient(@RequestBody SaveCLientRequest request) {
        clientEntityService.save(request);

        return clientEntityService.save(request);
    }

    @DeleteMapping("/clients/delete/{id}")
    public String deleteClient(@PathVariable("id") int id) {
        String result = clientEntityService.deleteById(id);
        return result;
    }


}
