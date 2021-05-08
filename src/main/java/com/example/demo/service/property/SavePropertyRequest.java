package com.example.demo.service.property;
import com.example.demo.enumerations.PropertyStatus;
import com.example.demo.enumerations.Type;
import lombok.Data;

import javax.persistence.*;

@Data
public class SavePropertyRequest {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private int price;

    private String description;

    @Enumerated(EnumType.STRING)
    private Type type;

    private int yearBuild;

    private int squareFit;

    private int bedroom;

    private int bathroom;

    @Enumerated(EnumType.STRING)
    private PropertyStatus propertyStatus;

    private String location;

    private boolean Featured;

    private int categoryId;
}
