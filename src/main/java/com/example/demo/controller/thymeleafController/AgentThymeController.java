package com.example.demo.controller.thymeleafController;

import com.example.demo.service.agent.AgentService;
import com.example.demo.service.category.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Agent;


@Controller
public class AgentThymeController {
    private AgentService agentService;
    CategoryService categoryService;

    public AgentThymeController(final AgentService agentService, CategoryService categoryService) {
        this.agentService = agentService;
        this.categoryService=categoryService;

    }

    @GetMapping("/agent")
    public String agents(final ModelMap modelMap) {
        var agentlist = this.agentService.findAll();
        modelMap.addAttribute("agents", agentlist);
        var categories=this.categoryService.findAll();
        modelMap.addAttribute("categories",categories);
        return "agent";
    }
}
