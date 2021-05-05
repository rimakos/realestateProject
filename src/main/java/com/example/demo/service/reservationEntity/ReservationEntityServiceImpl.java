package com.example.demo.service.reservationEntity;

import com.example.demo.dao.PropertyEntityRepository;
import com.example.demo.dao.ReservationEntityRepository;
import com.example.demo.entity.ReservationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationEntityServiceImpl implements ReservationEntityService {

    private ReservationEntityRepository reservationEntityRepository;
    private PropertyEntityRepository propertyEntityRepository;

    @Autowired
    public ReservationEntityServiceImpl
            (ReservationEntityRepository theReservationEntityRepository, PropertyEntityRepository thePropertyEntityRepository) {
        propertyEntityRepository = thePropertyEntityRepository;
        reservationEntityRepository = theReservationEntityRepository;
    }

    @Override
    public List<ReservationEntity> findAll() {
        return reservationEntityRepository.findAll();
    }

    @Override
    public ReservationEntity findById(int theId) {
        return reservationEntityRepository.findById(theId).orElse(null);
    }

    @Override
    public void save(ReservationEntity reservationEntity) {
reservationEntityRepository.save(reservationEntity);
    }

    @Override
    public String deleteById(int theId) {
        Optional<ReservationEntity> reservationEntity = reservationEntityRepository.findById(theId);
        if (reservationEntity.isPresent()) {
            reservationEntityRepository.deleteById(theId);
            return "The Reservation with id " + theId + " is deleted";
        } else {
            return "The id " + theId + " you enter to delete does not exist";
        }}

    @Override
    public List<ReservationEntity> getClientReservations(int clientId) {
        return propertyEntityRepository.getClientReservations(clientId);
    }


}
