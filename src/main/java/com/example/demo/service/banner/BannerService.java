package com.example.demo.service.banner;

import com.example.demo.entity.Banner;
import com.example.demo.entity.Category;
import com.example.demo.service.category.SaveCategoryRequest;

import java.util.List;

public interface BannerService {

     List<Banner> findAll();
     int save(Banner banner);
     Banner findById(int id);
     void deleteById(int theId);

}
