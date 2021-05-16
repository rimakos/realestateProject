package com.example.demo.service.post;

import lombok.Data;

@Data
public class SavePostRequest {

    private int id;

    private String title;

    private String description;

    private String photo;

}
