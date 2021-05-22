package com.example.demo.controller.thymeleafController;

import com.example.demo.entity.Property;
import com.example.demo.enumerations.PropertyStatus;
import com.example.demo.service.banner.BannerService;
import com.example.demo.service.category.CategoryService;
import com.example.demo.service.property.PropertyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Properties;

@Controller
public class HomeController {
    private PropertyService propertyService;
    private BannerService bannerService;
    private CategoryService categoryService;

    public HomeController(final PropertyService propertyService, BannerService bannerService, CategoryService categoryService) {
        this.propertyService = propertyService;
        this.bannerService = bannerService;
        this.categoryService = categoryService;

    }

    @GetMapping("/")
    public String index(final ModelMap modelMap) {
        var properties = this.propertyService.findAll();
        modelMap.addAttribute("properties", properties);

        var propertiesFeatured = this.propertyService.findByFeatured();
        modelMap.addAttribute("propertiesFeatured", propertiesFeatured);

        var banners = this.bannerService.findAll();
        modelMap.addAttribute("banners", banners);

        var categories = this.categoryService.findAll();
        modelMap.addAttribute("categories", categories);
        return "index";
    }

        @GetMapping("/searchbox")
        public String searchBox(final ModelMap modelMap , @RequestParam(value = "id") int id, @RequestParam(value = "status")PropertyStatus propertyStatus) {

        var searchBox = this.propertyService.searchBox(id,propertyStatus);
            modelMap.addAttribute("searchbox", searchBox);

            var banners = this.bannerService.findAll();
            modelMap.addAttribute("banners", banners);

            return "searchbox";

        }


    @GetMapping("/view-list")
    public String viewList(final ModelMap modelMap) {
        var properties = this.propertyService.findAll();
        modelMap.addAttribute("properties", properties);

        var banners = this.bannerService.findAll();
        modelMap.addAttribute("banners", banners);

        var categories = this.categoryService.findAll();
        modelMap.addAttribute("categories", categories);
        return "view-list";

    }
}
