package com.project.gestioncinema.Service;

import com.project.gestioncinema.Entities.Seance;

import java.util.List;

public interface SeanceService {

    Seance createSeance(Seance seance);
    Seance updateSeance(Long id, Seance seance);
    void deleteSeance(Long id);
    Seance getSeanceById(Long id);
    List<Seance> getAllSeances();
    List<Seance> getSeancesByFilm(Long filmId);
    List<Seance> getSeancesBySalle(Long salleId);
}
