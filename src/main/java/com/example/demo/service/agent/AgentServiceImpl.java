package com.example.demo.service.agent;

import com.example.demo.dao.AgentRepository;
import com.example.demo.entity.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentServiceImpl implements AgentService {
    public AgentRepository agentRepository;

    @Autowired
    public AgentServiceImpl(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    @Override
    public List<Agent> findAll() {
        return agentRepository.findAll();
    }

    @Override
    public Agent findById(int theId) {
        return agentRepository.findById(theId).orElse(null);
    }


    public int save(Agent agent) {
        var dbAgent = agentRepository.findById(agent.getId());
        if (dbAgent.isPresent()) {
            dbAgent.get().setName(agent.getName());
            dbAgent.get().setPhoto(agent.getPhoto());
            dbAgent.get().setBio(agent.getBio());
            agentRepository.save(dbAgent.get());
            return dbAgent.get().getId();
        }
        var newAgent = Agent.builder()
                .name(agent.getName())
                .photo(agent.getPhoto())
                .bio(agent.getBio())
                .build();
        agentRepository.save(newAgent);
        return newAgent.getId();
    }
    @Override
    public void deleteById(int theId) {
        Agent agent = agentRepository.findById(theId).orElseThrow(() -> new IllegalArgumentException());
        agentRepository.delete(agent);
    }

}
