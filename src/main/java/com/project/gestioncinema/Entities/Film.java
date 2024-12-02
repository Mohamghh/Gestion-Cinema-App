package com.project.gestioncinema.Entities;

import jakarta.persistence.*;
import lombok.*;

<<<<<<< HEAD
import java.time.Duration;
=======
import java.math.BigDecimal;
import java.util.List;
>>>>>>> master

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
<<<<<<< HEAD
=======
    private BigDecimal prix;
>>>>>>> master
    private String imageName;
    private String imageType;
    @Lob
    private byte[] image;
<<<<<<< HEAD
=======
    @OneToMany
    List<Seance> seanceList;
>>>>>>> master

}
