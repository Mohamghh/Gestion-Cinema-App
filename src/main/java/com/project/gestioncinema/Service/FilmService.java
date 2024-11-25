package com.project.gestioncinema.Service;

import com.project.gestioncinema.Entities.Film;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FilmService {
   List<Film> getAllFilms();
   Film getFilmById(Long id);
   Film addFilm(Film film , MultipartFile imageFile) throws IOException;
}
