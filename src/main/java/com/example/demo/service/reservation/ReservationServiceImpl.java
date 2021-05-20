package com.example.demo.service.reservation;

import com.example.demo.dao.ClientRepository;
import com.example.demo.dao.ReservationRepository;
import com.example.demo.entity.Client;
import com.example.demo.entity.Property;
import com.example.demo.entity.Reservation;
import com.example.demo.service.client.SaveClientRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {
    public ReservationRepository reservationRepository;
    public ClientRepository clientRepository;

    @Autowired
    public ReservationServiceImpl(ClientRepository theClientRepository, ReservationRepository theReservationRepository) {
        reservationRepository = theReservationRepository;
        clientRepository = theClientRepository;
    }

    @Override
    @Transactional
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }


    public int save(SaveNewClientReservationDTO request) {

        Client newClient = new Client();
        newClient.setName(request.getClientName());
        newClient.setEmail(request.getClientEmail());
        newClient.setPhoneNumber(request.getPhoneNumber());
        newClient.getCreatedAt();
        clientRepository.save(newClient);

        Reservation newReservation = new Reservation();
        newReservation.setFinalPrice(request.getFinalPrice());
        newReservation.setClientId(newClient.getId());
        newReservation.setPropertyId(request.getPropertyId());
        newReservation.setCreatedAt(new Date());

        reservationRepository.save(newReservation);

        return newClient.getId();


    }

//
//    @Override
//    public int save(SaveReservationRequest request) {
//        var dbReservationEntity = reservationRepository.findById(request.getId());
//        if (dbReservationEntity.isPresent()) {
//            dbReservationEntity.get().setId(request.getId());
//            dbReservationEntity.get().setClientId(request.getClientId());
//            dbReservationEntity.get().setFinalPrice(request.getFinalPrice());
//            dbReservationEntity.get().setComment(request.getComment());
//            reservationRepository.save(dbReservationEntity.get());
//            return dbReservationEntity.get().getId();
//        }
//        var newReservation = Reservation.builder()
//                .id(request.getId())
//                .finalPrice(request.getFinalPrice())
//                .clientId(request.getClientId())
//                .comment(request.getComment())
//                .createdAt(new Date())
//                .build();
//
//        reservationRepository.save(newReservation);
//        return newReservation.getId();
//    }
//


    @Override
    public Reservation findById(int theId) {
        return reservationRepository.findById(theId).orElse(null);
    }

    @Override
    public void deleteById(int theId) {
        Reservation reservationEntity = reservationRepository.findById(theId).orElseThrow(() ->
                new IllegalArgumentException());
        reservationRepository.delete(reservationEntity);
    }


}
