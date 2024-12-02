package com.project.gestioncinema.Service;

import com.project.gestioncinema.Entities.Salle;
import com.project.gestioncinema.Repository.SalleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalleServiceImpl implements SalleService {

    private final SalleRepo salleRepository;


    @Autowired
    public SalleServiceImpl(SalleRepo salleRepository) {
        this.salleRepository = salleRepository;
    }

    @Override
    public Salle createSalle(Salle salle) {
        return salleRepository.save(salle);
    }

    @Override
    public Salle updateSalle(Long id, Salle salle) {
        Salle existingSalle = salleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Salle not found with id: " + id));

        existingSalle.setNumeroSalle(salle.getNumeroSalle());
        existingSalle.setCapacitePlaces(salle.getCapacitePlaces());
        return salleRepository.save(existingSalle);
    }

    @Override
    public void deleteSalle(Long id) {
        if (!salleRepository.existsById(id)) {
            throw new ResourceNotFoundException("Salle not found with id: " + id);
        }
        salleRepository.deleteById(id);
    }

    @Override
    public Salle getSalleById(Long id) {
        return salleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Salle not found with id: " + id));
    }

    @Override
    public List<Salle> getAllSalles() {
        return salleRepository.findAll();
    }
}
