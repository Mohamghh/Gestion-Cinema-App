package com.project.gestioncinema.Repository;

import com.project.gestioncinema.Entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalleRepo extends JpaRepository<Salle, Long> {
}
