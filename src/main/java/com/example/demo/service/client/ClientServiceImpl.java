package com.example.demo.service.client;

import com.example.demo.dao.ClientRepository;
import com.example.demo.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository theClientRepository) {
        clientRepository = theClientRepository;
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(int theId) {
        return clientRepository.findById(theId).orElse(null);
    }

    @Override
    public int save(SaveClientRequest request) {
        var dbClient = clientRepository.findById(request.getId());
        if (dbClient.isPresent()) {
            dbClient.get().setEmail(request.getEmail());
            dbClient.get().setPhoneNumber(request.getPhoneNumber());
            dbClient.get().setName(request.getName());
            clientRepository.save(dbClient.get());
            return dbClient.get().getId();
        }
        var newClient = Client.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .createdAt(new Date())
                .build();
        clientRepository.save(newClient);
        return newClient.getId();

    }


    @Override
    public void deleteById(int theId) {
        Client client = clientRepository.findById(theId).orElseThrow(() -> new IllegalArgumentException());
        clientRepository.delete(client);
    }


}
