package com.example.demo.service.propertyEntity;


import com.example.demo.enumerations.PropertyStatus;
import com.example.demo.enumerations.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "properties")
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
