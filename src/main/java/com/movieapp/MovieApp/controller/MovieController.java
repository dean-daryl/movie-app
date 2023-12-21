package com.movieapp.MovieApp.controller;


import com.movieapp.MovieApp.MovieRecord;
import com.movieapp.MovieApp.service.MovieService;
import com.movieapp.MovieApp.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    @Autowired
    public  MovieController(MovieService movieService){
        this.movieService = movieService;
    }
    @PostMapping("/add")
    public Movie addMovie(@RequestBody Movie movie){
        return movieService.addMovie(movie);
    }
    @GetMapping("/all")
    public List<MovieRecord> getAllMovies(){
        return movieService.getAllMovies();
    }
    @GetMapping("/single/{id}")
    public ResponseEntity<Movie> getSingleMovieById(@PathVariable UUID id){
        return movieService.getSingleMovie(id);
    }

    @PatchMapping("/{genre_id}/{movie_id}")
    public Movie addGenreToMovie(@PathVariable UUID genre_id, @PathVariable UUID movie_id){
        return movieService.addGenreToMovie(genre_id,movie_id);
    }

    @DeleteMapping("delete/{id}")
    public String deleteSingleMovie(@PathVariable UUID id){
        return movieService.deleteMovie(id);
    }
}