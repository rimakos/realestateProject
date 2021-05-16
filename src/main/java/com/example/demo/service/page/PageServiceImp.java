package com.example.demo.service.page;

import com.example.demo.dao.PageRepository;
import com.example.demo.entity.Page;
import com.example.demo.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageServiceImp implements PageService {
    private PageRepository pageRepository;

    @Autowired
    public PageServiceImp(PageRepository pageRepository){
        this.pageRepository = pageRepository;
    }

    @Override
    public List<Page> findAll() {
        return pageRepository.findAll();
    }

    @Override
    public Page findById(int theId) {
        return pageRepository.findById(theId).orElse(null);
    }

    @Override
    public int save(SavePageRequest request) {
        var dbPage = pageRepository.findById(request.getId());
        if(dbPage.isPresent()){
            dbPage.get().setTitle(request.getTitle());
            dbPage.get().setPhoto(request.getPhoto());
            dbPage.get().setContent(request.getContent());
            pageRepository.save(dbPage.get());
            return dbPage.get().getId();
        }
        var newPage = Page.builder()
                .title(request.getTitle())
                .photo(request.getPhoto())
                .content(request.getContent())
                .build();
        pageRepository.save(newPage);
        return newPage.getId();
    }

    @Override
    public void deleteById(int theId) {
        Page page = pageRepository.findById(theId).orElseThrow(()-> new IllegalArgumentException());
        pageRepository.delete(page);
    }
}
