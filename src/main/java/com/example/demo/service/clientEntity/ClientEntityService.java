package com.example.demo.service.clientEntity;

import com.example.demo.entity.ClientEntity;


import java.util.List;

public interface ClientEntityService {

    public List<ClientEntity> findAll();

    public ClientEntity findById(int theId);

    public void save(ClientEntity clientEntity);

    public String deleteById(int theId);

}
