package com.project.gestioncinema.Service;

import com.project.gestioncinema.Entities.Salle;

import java.util.List;

public interface SalleService {

    Salle createSalle(Salle salle);
    Salle updateSalle(Long id, Salle salle);
    void deleteSalle(Long id);
    Salle getSalleById(Long id);
    List<Salle> getAllSalles();
}
