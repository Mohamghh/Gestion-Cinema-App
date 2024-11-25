package com.project.gestioncinema.Web;

import com.project.gestioncinema.Entities.Seance;
import com.project.gestioncinema.Service.SeanceService;
import com.project.gestioncinema.Repository.SeanceRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class SeanceController {
    private final SeanceService seanceService;
    private final SeanceRepo seanceRepository;


    @GetMapping("/seances")
    public List<Seance> getAllSeances() {
        return seanceService.getAllSeances();
    }


    @GetMapping("/seance/{id}")
    public Seance getSeanceById(@PathVariable Long id) {
        return seanceService.getSeanceById(id);
    }


    @PostMapping( "/addseance")
    public ResponseEntity<Seance> addSeance(@RequestBody Seance seance) {
        try {
            Seance savedSeance = seanceService.createSeance(seance);
            return new ResponseEntity<>(savedSeance, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/seance/{id}")
    public ResponseEntity<Seance> updateSeance(@PathVariable Long id, @RequestBody Seance seance) {
        Seance updatedSeance = seanceService.updateSeance(id, seance);
        if (updatedSeance != null) {
            return new ResponseEntity<>(updatedSeance, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/seance/{id}")
    public ResponseEntity<Void> deleteSeance(@PathVariable Long id) {
        try {
            seanceService.deleteSeance(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/seances/film/{filmId}")
    public List<Seance> getSeancesByFilm(@PathVariable Long filmId) {
        return seanceService.getSeancesByFilm(filmId);
    }


    @GetMapping("/seances/salle/{salleId}")
    public List<Seance> getSeancesBySalle(@PathVariable Long salleId) {
        return seanceService.getSeancesBySalle(salleId);
    }
}
