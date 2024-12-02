package com.project.gestioncinema.Web;

import com.project.gestioncinema.Entities.Seance;
import com.project.gestioncinema.Service.SeanceService;
<<<<<<< HEAD
import com.project.gestioncinema.Repository.SeanceRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
=======
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
>>>>>>> master
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class SeanceController {
<<<<<<< HEAD
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
=======
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
>>>>>>> master
    public ResponseEntity<Seance> updateSeance(@PathVariable Long id, @RequestBody Seance seance) {
        Seance updatedSeance = seanceService.updateSeance(id, seance);
        if (updatedSeance != null) {
            return new ResponseEntity<>(updatedSeance, HttpStatus.OK);
<<<<<<< HEAD
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
=======
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
>>>>>>> master
    }
}
