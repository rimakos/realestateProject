package com.example.demo.controller.thymeleafController;

import com.example.demo.enumerations.PropertyStatus;
import com.example.demo.service.category.CategoryService;
import com.example.demo.service.property.PropertyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RentPropertyController {
    private PropertyService propertyService;
    private CategoryService categoryService;

    public RentPropertyController(final PropertyService propertyService
            , CategoryService categoryService) {
        this.propertyService = propertyService;
        this.categoryService = categoryService;
    }

    @GetMapping("/rent")
    public String rent(final ModelMap modelMap) {
        var rentStatus = this.propertyService.findPropertiesByStatus(PropertyStatus.Rent);
        modelMap.addAttribute("rentStatus", rentStatus);
        var categories = this.categoryService.findAll();
        modelMap.addAttribute("categories", categories);
        return "rent";
    }
}
