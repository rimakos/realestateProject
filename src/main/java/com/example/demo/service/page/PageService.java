package com.example.demo.service.page;

import com.example.demo.entity.Page;

import java.util.List;

public interface PageService {
    List<Page> findAll();

    Page findById(int theId);

    int save (SavePageRequest request);

    void deleteById(int theId);
}
