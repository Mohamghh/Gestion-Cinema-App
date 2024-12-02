package com.project.gestioncinema.Repository;

import com.project.gestioncinema.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, Long> {
}
