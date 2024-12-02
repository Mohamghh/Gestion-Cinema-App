package com.project.gestioncinema.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalTime heureDebut;
    private LocalTime heureFin;
<<<<<<< HEAD
=======

>>>>>>> master
    @ManyToOne
    private Film film;
    @ManyToOne
    private Salle salle;
}

