package com.example.demo.controller;

import com.example.demo.entity.Agent;
import com.example.demo.service.agent.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agents")
public class AgentController {
    private AgentService agentService;

    @Autowired
    public AgentController
            (AgentService agentService) {
        this.agentService = agentService;
    }

    @GetMapping
    public List<Agent> findAll() {
        return agentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getAgent(@PathVariable int id) {
        Agent agent = agentService.findById(id);
        if (agent == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(agent);
    }


    @PostMapping
    public int addAgent(@RequestBody Agent agent) {
        return agentService.save(agent);

    }

    @DeleteMapping("/{id}")
    public void deleteAgent(@PathVariable("id") int id) {
        agentService.deleteById(id);
    }
}

