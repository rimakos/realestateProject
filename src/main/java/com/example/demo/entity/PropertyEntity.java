package com.example.demo.entity;

import com.example.demo.enumerations.PropertyStatus;
import com.example.demo.enumerations.Type;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "properties")
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private Integer price;

    private String description;

    @Enumerated(EnumType.STRING)
    private Type type;

    private Integer yearBuild;

    private Integer squareFit;

    private Integer bedroom;

    private Integer bathroom;

    @Enumerated(EnumType.STRING)
    private PropertyStatus propertyStatus;

    private String location;

    private boolean Featured;

    private Date createdAt;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryId", insertable = false, updatable = false)
    private CategoryEntity categoryEntity;
    private int categoryId;



}

