package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int finalPrice;

    private String comment;

    private Date createdAt;


    @ManyToOne
    @JoinColumn(name = "clientId", insertable = false, updatable = false)
    private Client client;
    private int clientId;

    @ManyToOne
    @JoinColumn(name = "propertyId", insertable = false, updatable = false)
    private Property property;
    private int propertyId;


}
