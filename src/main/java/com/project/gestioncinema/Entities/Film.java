package com.project.gestioncinema.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private Long duree;
    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private Genre genre;
    private BigDecimal prix;
    private String imageName;
    private String imageType;
    @Lob
    private byte[] image;
    @OneToMany
    List<Seance> seanceList;

}
