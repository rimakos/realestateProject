package com.example.demo.entity;

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
public class PropertyEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

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

}

