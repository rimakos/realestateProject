package com.example.demo.controller;

import com.example.demo.entity.Page;
import com.example.demo.service.page.PageService;
import com.example.demo.service.page.SavePageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pages")
public class PageController {

    private PageService pageService;

    @Autowired
    public PageController(PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping
    public List<Page> findAll() {
        return pageService.findAll();
    }

    @GetMapping("/{pageId}")
    public ResponseEntity getPage(@PathVariable int pageId) {
        Page page = pageService.findById(pageId);
        if (page == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(page);
    }

    @PostMapping
    public int addPage(@RequestBody SavePageRequest request) {
        return pageService.save(request);
    }

    @DeleteMapping("/{id}")
    public void deletePage(@PathVariable("id") int id) {
        pageService.deleteById(id);
    }
}
