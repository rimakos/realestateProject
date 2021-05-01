package com.example.demo.entity;

import com.example.demo.enumerations.CategoryName;
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
@Table(name = "categories")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private CategoryName categoryName;

}
