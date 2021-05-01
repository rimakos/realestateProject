package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "clients")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @NotEmpty(message = "{email.notEmpty}")
    private String email;

    private String phoneNumber;

}
