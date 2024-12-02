package com.project.gestioncinema.Web;

import com.project.gestioncinema.Entities.Seance;
import com.project.gestioncinema.Service.SeanceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class SeanceController {
    @Autowired
    private SeanceService seanceService;

    @PostMapping("/AddSeance")
    public ResponseEntity<Seance> createSeance(@RequestBody Seance seance) {
        try {
            Seance createdSeance = seanceService.createSeance(seance);
            return new ResponseEntity<>(createdSeance, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/UpdateSeance/{id}")
    public ResponseEntity<Seance> updateSeance(@PathVariable Long id, @RequestBody Seance seance) {
        Seance updatedSeance = seanceService.updateSeance(id, seance);
        if (updatedSeance != null) {
            return new ResponseEntity<>(updatedSeance, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/seance/{id}")
    public ResponseEntity<Void> deleteSeance(@PathVariable Long id) {
        seanceService.deleteSeance(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/Seance/{id}")
    public ResponseEntity<Seance> getSeanceById(@PathVariable Long id) {
        Seance seance = seanceService.getSeanceById(id);
        if (seance != null) {
            return new ResponseEntity<>(seance, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/seances")
    public ResponseEntity<List<Seance>> getAllSeances() {
        List<Seance> seances = seanceService.getAllSeances();
        return new ResponseEntity<>(seances, HttpStatus.OK);
    }

    @GetMapping("/film/{filmId}")
    public ResponseEntity<List<Seance>> getSeancesByFilm(@PathVariable Long filmId) {
        List<Seance> seances = seanceService.getSeancesByFilm(filmId);
        return new ResponseEntity<>(seances, HttpStatus.OK);
    }

    @GetMapping("/salle/{salleId}")
    public ResponseEntity<List<Seance>> getSeancesBySalle(@PathVariable Long salleId) {
        List<Seance> seances = seanceService.getSeancesBySalle(salleId);
        return new ResponseEntity<>(seances, HttpStatus.OK);
    }
}
