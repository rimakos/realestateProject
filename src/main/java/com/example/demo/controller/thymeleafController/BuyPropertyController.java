package com.example.demo.controller.thymeleafController;

import com.example.demo.entity.Property;
import com.example.demo.enumerations.PropertyStatus;
import com.example.demo.service.banner.BannerService;
import com.example.demo.service.category.CategoryService;
import com.example.demo.service.property.PropertyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BuyPropertyController {
    private PropertyService propertyService;
    private CategoryService categoryService;

    public BuyPropertyController(final PropertyService propertyService, CategoryService categoryService) {
        this.propertyService = propertyService;
        this.categoryService = categoryService;

    }

    @GetMapping("/buy")
    public String buy(final ModelMap modelMap) {
        var buyStatus = this.propertyService.findPropertiesByStatus(PropertyStatus.Sale);
        modelMap.addAttribute("buyStatus", buyStatus);
        var categories=this.categoryService.findAll();
        modelMap.addAttribute("categories",categories);
        return "buy";
    }
}
