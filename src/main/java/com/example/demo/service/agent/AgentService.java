package com.example.demo.service.agent;

import com.example.demo.entity.Agent;

import java.util.List;

public interface AgentService {
    List<Agent> findAll();
    int save(Agent agent);

    Agent findById(int id);
    void deleteById(int theId);
}
