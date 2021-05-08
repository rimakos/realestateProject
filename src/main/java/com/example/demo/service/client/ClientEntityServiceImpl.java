package com.example.demo.service.client;

import com.example.demo.dao.ClientEntityRepository;
import com.example.demo.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClientEntityServiceImpl implements ClientEntityService {

    private ClientEntityRepository clientEntityRepository;

    @Autowired
    public ClientEntityServiceImpl(ClientEntityRepository theClientEntityRepository) {
        clientEntityRepository = theClientEntityRepository;
    }

    @Override
    public List<Client> findAll() {
        return clientEntityRepository.findAll();
    }

    @Override
    public Client findById(int theId) {
        return clientEntityRepository.findById(theId).orElse(null);
    }

    @Override
    public int save(SaveCLientRequest request) {
        var dbClient = clientEntityRepository.findById(request.getId());
        if (dbClient.isPresent()) {
            dbClient.get().setEmail(request.getEmail());
            dbClient.get().setPhoneNumber(request.getPhoneNumber());
            dbClient.get().setName(request.getName());
            clientEntityRepository.save(dbClient.get());
            return dbClient.get().getId();
        }
        var newClient = Client.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .createdAt(new Date())
                .build();
        clientEntityRepository.save(newClient);
        return newClient.getId();

    }


    @Override
    public void deleteById(int theId) {
        Client client = clientEntityRepository.findById(theId).orElseThrow(() -> new IllegalArgumentException());
        clientEntityRepository.delete(client);
    }


}
