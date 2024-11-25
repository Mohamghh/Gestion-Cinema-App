package com.project.gestioncinema.Service;

import com.project.gestioncinema.Entities.Film;
import com.project.gestioncinema.Repository.FilmRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@Service
@AllArgsConstructor
public class FilmImp implements FilmService{
    @Autowired
    private FilmRepo filmRepo;
    @Override
    public List<Film> getAllFilms() {
        return filmRepo.findAll();
    }

    @Override
    public Film getFilmById(Long id) {
        return filmRepo.findById(id).get();
    }

    @Override
    public Film addFilm(Film film, MultipartFile imageFile) throws IOException {
        film.setImageName(imageFile.getOriginalFilename());
        film.setImageType(imageFile.getContentType());
        film.setImage(imageFile.getBytes());
        return filmRepo.save(film);
    }
}
