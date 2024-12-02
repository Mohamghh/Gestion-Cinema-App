package com.project.gestioncinema.Entities;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientFidele extends Client {

    private String statutAbonnement;
    private int pointsFidelite;
}
