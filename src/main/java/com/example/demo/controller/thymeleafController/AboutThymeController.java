package com.example.demo.controller.thymeleafController;

import com.example.demo.service.category.CategoryService;
import com.example.demo.service.page.PageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutThymeController {
    private PageService pageService;
    private CategoryService categoryService;

    public AboutThymeController(PageService pageService, CategoryService categoryService) {
        this.pageService = pageService;
        this.categoryService = categoryService;
    }

    @GetMapping("/about")
    public String aboutList(final ModelMap modelMap){
        var aboutList= this.pageService.findAll();
    modelMap.addAttribute("pages", aboutList);
    var categories=this.categoryService.findAll();
    modelMap.addAttribute("categories",categories);
    return "about";
    }
}
