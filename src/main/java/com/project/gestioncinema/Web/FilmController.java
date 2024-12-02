package com.project.gestioncinema.Web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.gestioncinema.Entities.Film;
import com.project.gestioncinema.Repository.FilmRepo;
import com.project.gestioncinema.Service.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class FilmController {
    private FilmService filmService;
    private FilmRepo filmRepo;

    @GetMapping("/films")
    public List<Film> getAllFilms() {
        List<Film> films = filmService.getAllFilms();
        return films;
    }

    @GetMapping("/film/{id}")
    public Film get(@PathVariable Long id) {
        return filmRepo.findById(id).get();
    }

@PostMapping(value = "/addfilm" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Film> addFilm(@RequestPart("film")String filmJson,
                                        @RequestPart("file") MultipartFile imageFile) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Film film = objectMapper.readValue(filmJson, Film.class);
            Film saveFilm = filmService.addFilm(film, imageFile);
            return new ResponseEntity<>(saveFilm, HttpStatus.CREATED);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);

        }
}


}
