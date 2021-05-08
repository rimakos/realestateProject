package com.example.demo.service.client;

import com.example.demo.entity.Client;


import java.util.List;

public interface ClientService {

     List<Client> findAll();

     Client findById(int theId);

     int save(SaveClientRequest request);

     void deleteById(int theId);

}
