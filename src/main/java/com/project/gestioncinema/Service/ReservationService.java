package com.project.gestioncinema.Service;

import com.project.gestioncinema.Entities.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> getAllReservations();
    Reservation getReservationById(Long id);
    Reservation createReservation(Reservation reservation);
    Reservation updateReservation(Long id, Reservation updatedReservation);
    void deleteReservation(Long id);


}
