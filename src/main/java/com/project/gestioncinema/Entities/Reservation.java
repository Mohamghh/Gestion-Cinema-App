package com.project.gestioncinema.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date date_reservation;
    @ManyToOne
    private Seance seance;
    @ManyToOne
    private Client client;


}
