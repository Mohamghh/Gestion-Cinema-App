package com.project.gestioncinema.Service;

import com.project.gestioncinema.Entities.Seance;
import com.project.gestioncinema.Repository.FilmRepo;
import com.project.gestioncinema.Repository.SalleRepo;
import com.project.gestioncinema.Repository.SeanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeanceServiceImpl implements SeanceService {

    @Autowired
    private SeanceRepo seanceRepository;

    @Autowired
    private FilmRepo filmRepo;

    @Autowired
    private SalleRepo salleRepo;

    // 1. Create Seance
    @Override
    public Seance createSeance(Seance seance) {

        if (!filmRepo.existsById(seance.getFilm().getId())) {
            throw new IllegalArgumentException("Film not found.");
        }

        if (!isSalleAvailable(seance)) {
            throw new IllegalArgumentException("Salle is not available for this time.");
        }

        return seanceRepository.save(seance);
    }


    @Override
    public Seance updateSeance(Long id, Seance seance) {
        Optional<Seance> existingSeance = seanceRepository.findById(id);
        if (existingSeance.isPresent()) {
            Seance updatedSeance = existingSeance.get();
            updatedSeance.setHeureDebut(seance.getHeureDebut());
            updatedSeance.setHeureFin(seance.getHeureFin());
            updatedSeance.setFilm(seance.getFilm());
            updatedSeance.setSalle(seance.getSalle());
            return seanceRepository.save(updatedSeance);
        } else {
            return null;
        }
    }


    @Override
    public void deleteSeance(Long id) {
        seanceRepository.deleteById(id);
    }


    @Override
    public Seance getSeanceById(Long id) {
        return seanceRepository.findById(id).orElse(null);
    }


    @Override
    public List<Seance> getAllSeances() {
        return seanceRepository.findAll();
    }


    @Override
    public List<Seance> getSeancesByFilm(Long filmId) {
        return seanceRepository.findByFilmId(filmId);
    }


    @Override
    public List<Seance> getSeancesBySalle(Long salleId) {
        return seanceRepository.findBySalleId(salleId);
    }

    private boolean isSalleAvailable(Seance seance) {
        List<Seance> existingSeances = seanceRepository.findBySalleId(seance.getSalle().getId());
        return existingSeances.stream()
                .noneMatch(existingSeance -> existingSeance.getHeureDebut().equals(seance.getHeureDebut()) &&
                        existingSeance.getHeureFin().equals(seance.getHeureFin()));
    }
}
