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
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Integer finalPrice;

    private String comment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clientId", insertable = false, updatable = false)
    private ClientEntity clientEntity;
    private int clientId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "propertyId", insertable = false, updatable = false)
    private PropertyEntity propertyEntity;
    private int propertyId;
    private Date createdAt;


}
