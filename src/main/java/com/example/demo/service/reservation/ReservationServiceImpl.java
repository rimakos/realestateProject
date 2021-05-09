package com.example.demo.service.reservation;

import com.example.demo.dao.ReservationRepository;
import com.example.demo.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    public ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository theReservationRepository) {
        reservationRepository = theReservationRepository;
    }
    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
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
//    @Override
//    public void deleteById(int theId) {
//        Reservation reservationEntity = reservationRepository.findById(theId).orElseThrow(() -> new IllegalArgumentException());
//        reservationRepository.delete(reservationEntity);
//    }


}
