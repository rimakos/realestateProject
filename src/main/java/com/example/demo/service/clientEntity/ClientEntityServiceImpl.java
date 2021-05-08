package com.example.demo.service.clientEntity;

import com.example.demo.dao.ClientEntityRepository;
import com.example.demo.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
//        clientEntityRepository.save(request);
        var dbClient = clientEntityRepository.findById(request.getId());
        if (dbClient.isPresent()) {
            dbClient.get().setEmail(request.getEmail());
            dbClient.get().setPhoneNumber(request.getPhoneNumber());
            dbClient.get().setName(request.getName());
            clientEntityRepository.save(dbClient.get());
        }
        return dbClient.get().getId();

    }


    @Override
    public String deleteById(int theId) {
        Optional<Client> clientEntity = clientEntityRepository.findById(theId);
        if (clientEntity.isPresent()) {
            clientEntityRepository.deleteById(theId);
            return "The Client with id " + theId + " is deleted";
        } else {
            return "The id " + theId + " you enter to delete does not exist";
        }
    }

}
