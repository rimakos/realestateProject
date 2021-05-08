package com.example.demo.service.client;

import com.example.demo.entity.Client;


import java.util.List;

public interface ClientEntityService {

     List<Client> findAll();

     Client findById(int theId);

     int save(SaveCLientRequest request);

     void deleteById(int theId);

}
