package com.example.demo.controller.thymeleafController;

import com.example.demo.entity.Banner;
import com.example.demo.service.banner.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banners")
public class BannerController {

    private BannerService bannerService;


    @Autowired
    public BannerController
            (BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @GetMapping
    public List<Banner> findAll() {
        return bannerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getBanner(@PathVariable int id) {
        Banner banner = bannerService.findById(id);
        if (banner == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(banner);
    }


    @PostMapping
    public int addBanner(@RequestBody Banner banner) {
        return bannerService.save(banner);

    }

    @DeleteMapping("/{id}")
    public void deleteBanner(@PathVariable("id") int id) {
        bannerService.deleteById(id);
    }
}
