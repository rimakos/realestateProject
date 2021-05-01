package com.example.demo.service.clientEntity;

import com.example.demo.entity.ClientEntity;
import com.example.demo.entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientEntityService {
    public List<ClientEntity> findAll();

    public ClientEntity findById(int theId);

    public void save(ClientEntity clientEntity);

    public String deleteById(int theId);

}
