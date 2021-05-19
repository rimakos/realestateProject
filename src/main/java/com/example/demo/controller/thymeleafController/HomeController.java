package com.example.demo.controller.thymeleafController;

import com.example.demo.service.banner.BannerService;
import com.example.demo.service.category.CategoryService;
import com.example.demo.service.property.PropertyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Array;
import java.util.Arrays;

@Controller
public class HomeController {
    private PropertyService propertyService;
    private BannerService bannerService;
    private CategoryService categoryService;

    public HomeController(final PropertyService propertyService, BannerService bannerService,CategoryService categoryService) {
        this.propertyService = propertyService;
        this.bannerService = bannerService;
        this.categoryService=categoryService;

    }

    @GetMapping("/")
    public String index(final ModelMap modelMap) {
        var properties = this.propertyService.findAll();
        modelMap.addAttribute("properties", properties);

        var banners = this.bannerService.findAll();
        modelMap.addAttribute("banners", banners);
        var categories=this.categoryService.findAll();
        modelMap.addAttribute("categories",categories);
        return "index";
    }
}
