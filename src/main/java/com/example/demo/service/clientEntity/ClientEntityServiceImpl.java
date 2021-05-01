package com.example.demo.service.clientEntity;

import com.example.demo.dao.ClientEntityRepository;
import com.example.demo.entity.ClientEntity;
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
    public List<ClientEntity> findAll() {
        return clientEntityRepository.findAll();
    }

    @Override
    public ClientEntity findById(int theId) {
        return clientEntityRepository.findById(theId).orElse(null);
    }

    @Override
    public void save(ClientEntity theClientEntity) {
        clientEntityRepository.save(theClientEntity);

    }

    @Override
    public String deleteById(int theId) {
        Optional<ClientEntity> clientEntity = clientEntityRepository.findById(theId);
        if (clientEntity.isPresent()) {
            clientEntityRepository.deleteById(theId);
            return "The Client with id " + theId + " is deleted";
        } else {
            return "The id " + theId + " you enter to delete does not exist";
        }
    }

}
