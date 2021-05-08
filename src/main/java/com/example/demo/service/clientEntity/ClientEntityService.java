package com.example.demo.service.clientEntity;

import com.example.demo.entity.Client;


import java.util.List;

public interface ClientEntityService {

    public List<Client> findAll();

    public Client findById(int theId);

    public int save(SaveCLientRequest request);

    public String deleteById(int theId);

}
