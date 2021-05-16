package com.example.demo.dao;

import com.example.demo.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BannerRepository extends JpaRepository<Banner, Integer> {

}
