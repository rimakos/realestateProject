package com.example.demo.service.reservation;


import com.example.demo.entity.Client;
import com.example.demo.entity.Property;
import com.example.demo.entity.Reservation;
import lombok.Data;

@Data
public class SaveNewClientReservationDTO {
    private int id;
    private String clientName;
    private String clientEmail;
    private int propertyId;
    private int finalPrice;
    private String phoneNumber;


}
