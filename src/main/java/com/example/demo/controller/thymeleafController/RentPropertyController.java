package com.example.demo.controller.thymeleafController;

import com.example.demo.enumerations.PropertyStatus;
import com.example.demo.service.property.PropertyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RentPropertyController {
    private PropertyService propertyService;

    public RentPropertyController(final PropertyService propertyService) {
        this.propertyService = propertyService;

    }
    @GetMapping("/rent")
    public String buy(final ModelMap modelMap) {
        var rentStatus = this.propertyService.findPropertiesByStatus(PropertyStatus.Rent);
        modelMap.addAttribute("rentStatus", rentStatus);
        return "rent";
    }
}
