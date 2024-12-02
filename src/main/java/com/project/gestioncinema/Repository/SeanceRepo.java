package com.project.gestioncinema.Repository;

import com.project.gestioncinema.Entities.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeanceRepo extends JpaRepository<Seance, Long> {

    List<Seance> findByFilmId(Long filmId);
    List<Seance> findBySalleId(Long salleId);
}
