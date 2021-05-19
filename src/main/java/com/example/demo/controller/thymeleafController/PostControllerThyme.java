package com.example.demo.controller.thymeleafController;

import com.example.demo.service.category.CategoryService;
import com.example.demo.service.post.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostControllerThyme {
    private PostService postService;
    private CategoryService categoryService;

    public PostControllerThyme(final PostService postService,CategoryService categoryService) {
        this.postService=postService;
        this.categoryService=categoryService;
    }

    @GetMapping("/blog")
    public String posts(final ModelMap modelMap) {
        var blogList = this.postService.findAll();
        modelMap.addAttribute("blogs", blogList);
        var categories=this.categoryService.findAll();
        modelMap.addAttribute("categories",categories);
        return "blog";
    }
}
