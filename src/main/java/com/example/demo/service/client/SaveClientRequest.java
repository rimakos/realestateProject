package com.example.demo.service.client;

import lombok.Data;
import javax.validation.constraints.NotEmpty;

@Data

public class SaveClientRequest {


    private int id;

    @NotEmpty
    private String name;

    @NotEmpty(message = "{email.notEmpty}")
    private String email;

    private String phoneNumber;


}
