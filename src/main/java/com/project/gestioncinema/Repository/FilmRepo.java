package com.project.gestioncinema.Repository;

import com.project.gestioncinema.Entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepo extends JpaRepository<Film, Long> {

}
