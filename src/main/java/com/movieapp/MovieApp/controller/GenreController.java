package com.movieapp.MovieApp.controller;

import com.movieapp.MovieApp.model.Genres;
import com.movieapp.MovieApp.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {
    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService){
        this.genreService = genreService;
    }
    @GetMapping("/all")
    public Page<Genres> getAllGenres(Pageable pageable){
        return genreService.getAllGenres(pageable);
    }
    @PostMapping("/add")
    public Genres addGenre(@RequestBody Genres genre){
        return genreService.addGenre(genre);
    }
}
