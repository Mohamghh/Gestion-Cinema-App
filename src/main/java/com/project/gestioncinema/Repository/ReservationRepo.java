package com.project.gestioncinema.Repository;

import com.project.gestioncinema.Entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepo extends JpaRepository<Reservation, Long> {
}
