package com.example.demo.service.banner;

import com.example.demo.dao.BannerRepository;
import com.example.demo.entity.Banner;
import com.example.demo.entity.Category;
import com.example.demo.service.category.SaveCategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    public BannerRepository bannerRepository;

    @Autowired
    public BannerServiceImpl(BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
    }

    @Override
    public List<Banner> findAll() {
        return bannerRepository.findAll();
    }

    @Override
    public Banner findById(int theId) {
        return bannerRepository.findById(theId).orElse(null);
    }


    public int save(Banner banner) {
        var dbBanner = bannerRepository.findById(banner.getId());
        if (dbBanner.isPresent()) {
            dbBanner.get().setName(banner.getName());
            dbBanner.get().setPhoto(banner.getPhoto());
            bannerRepository.save(dbBanner.get());
            return dbBanner.get().getId();
        }
        var newBanner = Banner.builder()
                .name(banner.getName())
                .photo(banner.getPhoto())
                .build();
        bannerRepository.save(newBanner);
        return newBanner.getId();
    }
    @Override
    public void deleteById(int theId) {
        Banner banner = bannerRepository.findById(theId).orElseThrow(() -> new IllegalArgumentException());
        bannerRepository.delete(banner);
    }

}
