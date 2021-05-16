package com.example.demo.controller.thymeleafController;

import com.example.demo.entity.Property;
import com.example.demo.enumerations.PropertyStatus;
import com.example.demo.service.banner.BannerService;
import com.example.demo.service.property.PropertyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BuyPropertyController {
    private PropertyService propertyService;

    public BuyPropertyController(final PropertyService propertyService) {
        this.propertyService = propertyService;

    }
    @GetMapping("/buy")
    public String buy(final ModelMap modelMap) {
        var buyStatus = this.propertyService.findPropertiesByStatus(PropertyStatus.Sale);
        modelMap.addAttribute("buyStatus", buyStatus);
        return "buy";
    }
}
