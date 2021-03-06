package com.example.demo.controller.thymeleafController;

import com.example.demo.entity.Property;
import com.example.demo.service.banner.BannerService;
import com.example.demo.service.category.CategoryService;
import com.example.demo.service.property.PropertyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PropertiesByCategoryController {
    private PropertyService propertyService;
    private CategoryService categoryService;
    private BannerService bannerService;

    public PropertiesByCategoryController(final PropertyService propertyService, BannerService bannerService, CategoryService categoryService) {
        this.propertyService = propertyService;
        this.categoryService = categoryService;
        this.bannerService = bannerService;

    }

    @GetMapping("/properties/category/{categoryId}")
    public String getCategories(@PathVariable int categoryId, final ModelMap modelMap) {

        var properties = this.propertyService.findPropertiesByCategory(categoryId);
        modelMap.addAttribute("properties", properties);

        var banners = this.bannerService.findAll();
        modelMap.addAttribute("banners", banners);

        var categories = this.categoryService.findAll();
        modelMap.addAttribute("categories", categories);
        return "category";
    }
}
