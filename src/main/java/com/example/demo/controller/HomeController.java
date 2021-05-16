package com.example.demo.controller;

import com.example.demo.service.banner.BannerService;
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

    public HomeController(final PropertyService propertyService, BannerService bannerService) {
        this.propertyService = propertyService;
        this.bannerService = bannerService;

    }

    @GetMapping("/")
    public String index(final ModelMap modelMap) {
        modelMap.addAttribute("helloMsg", "hello in thymeleaf ");
//        modelMap.addAttribute("isSunny", true);
//        modelMap.addAttribute("fruits", Arrays.asList("Apple", "Orange", "Banana", "cherry"));
        var properties = this.propertyService.findAll();
        modelMap.addAttribute("properties", properties);

        var banners = this.bannerService.findAll();
        modelMap.addAttribute("banners", banners);
        return "index";
    }
}
