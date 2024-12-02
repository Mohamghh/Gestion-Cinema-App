package com.project.gestioncinema.Service;

import com.project.gestioncinema.Entities.Reservation;
import com.project.gestioncinema.Entities.Seance;
import com.project.gestioncinema.Repository.ReservationRepo;
import com.project.gestioncinema.Repository.SeanceRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservationImp implements ReservationService {
    @Lazy
    @Autowired
    private  SeanceRepo seanceRepo;
    private  ReservationRepo reservationRepo;


    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepo.findAll();
    }

    @Override
    public Reservation getReservationById(Long id) {
        return reservationRepo.findById(id).get();
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        Optional<Seance> optionalSeance = seanceRepo.findById(reservation.getSeance().getId());
        if (optionalSeance.isEmpty()) {
            throw new IllegalArgumentException("Seance not found.");
        }
        Seance seance = optionalSeance.get();
        reservation.setSeance(seance);
        return reservationRepo.save(reservation);
    }

    @Override
    public Reservation updateReservation(Long id, Reservation updatedReservation) {
        Optional<Reservation> existingReservation = reservationRepo.findById(id);
        if (existingReservation.isPresent()) {
            Reservation reservation = existingReservation.get();
            reservation.setSeance(updatedReservation.getSeance());
            return reservationRepo.save(reservation);
        } else {
            throw new IllegalArgumentException("Reservation not found.");
        }
    }

    @Override
    public void deleteReservation(Long id) {


    }

}



