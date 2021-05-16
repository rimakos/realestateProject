package com.example.demo.controller.thymeleafController;

import com.example.demo.service.post.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostControllerThyme {
    private PostService postService;

    public PostControllerThyme(final PostService postService) {
        this.postService=postService;
    }

    @GetMapping("/blog")
    public String posts(final ModelMap modelMap) {
        var blogList = this.postService.findAll();
        modelMap.addAttribute("blogs", blogList);
        return "blog";
    }
}
