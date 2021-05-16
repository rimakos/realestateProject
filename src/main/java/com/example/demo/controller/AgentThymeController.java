package com.example.demo.controller;

import com.example.demo.service.agent.AgentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Agent;


@Controller
public class AgentThymeController {
    private AgentService agentService;

    public AgentThymeController(final AgentService agentService) {
        this.agentService = agentService;

    }

    @GetMapping("/agent")
    public String agents(final ModelMap modelMap) {
        var agentlist = this.agentService.findAll();
        modelMap.addAttribute("agents", agentlist);
        return "agent";
    }
}
