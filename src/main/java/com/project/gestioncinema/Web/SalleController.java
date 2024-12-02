package com.project.gestioncinema.Web;


import com.project.gestioncinema.Entities.Salle;
import com.project.gestioncinema.Service.SalleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController

public class SalleController {

    private final SalleService salleService;

    @Autowired
    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }


    @GetMapping("/salles")
    public ResponseEntity<List<Salle>> getAllSalles() {
        List<Salle> salles = salleService.getAllSalles();
        return new ResponseEntity<>(salles, HttpStatus.OK);
    }


    @GetMapping("salle/{id}")
    public ResponseEntity<Salle> getSalleById(@PathVariable Long id) {
        Salle salle = salleService.getSalleById(id);
        return new ResponseEntity<>(salle, HttpStatus.OK);
    }


    @PostMapping("/AddSalle")
    public ResponseEntity<Salle> createSalle(@RequestBody Salle salle) {
        Salle createdSalle = salleService.createSalle(salle);
        return new ResponseEntity<>(createdSalle, HttpStatus.CREATED);
    }


    @PutMapping("updateSalle/{id}")
    public ResponseEntity<Salle> updateSalle(@PathVariable Long id, @RequestBody Salle salle) {
        Salle updatedSalle = salleService.updateSalle(id, salle);
        return new ResponseEntity<>(updatedSalle, HttpStatus.OK);
    }

    @DeleteMapping("/salle/{id}")
    public ResponseEntity<Void> deleteSalle(@PathVariable Long id) {
        salleService.deleteSalle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
