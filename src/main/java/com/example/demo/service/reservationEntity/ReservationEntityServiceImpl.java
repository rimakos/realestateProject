package com.example.demo.service.reservationEntity;

import com.example.demo.dao.PropertyEntityRepository;
import com.example.demo.dao.ReservationEntityRepository;
import com.example.demo.entity.ReservationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public ReservationEntity findById(int theId) {
        return null;
    }

    @Override
    public void save(ReservationEntity reservationEntity) {

    }

    @Override
    public void deleteById(int theId) {

    }

    @Override
    public List<ReservationEntity> getClientReservations(int clientId) {
        return propertyEntityRepository.getClientReservation(clientId);
    }


}
