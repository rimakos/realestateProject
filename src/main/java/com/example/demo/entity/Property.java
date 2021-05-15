package com.example.demo.entity;

import com.example.demo.enumerations.PropertyStatus;
import com.example.demo.enumerations.Type;
import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "properties")
public class Property {

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

    private Date createdAt;

    private int categoryId;

    private String photo;

    @ManyToOne
    @JoinColumn(name = "categoryId", insertable = false, updatable = false)
    private Category category;


}

