package com.example.demo.service.reservation;

import lombok.Data;

@Data
public class SaveReservationRequest {
    private int id;
    private int clientId;
    private int finalPrice;
    private String comment;


}
