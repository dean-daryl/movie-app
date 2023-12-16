package com.movieapp.MovieApp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Optional<Movie> getSingleMovieById(@PathVariable UUID id){
        return movieService.getSingleMovie(id);
    }

//    @DeleteMapping("delete/{id}")
//    public String deleteSingleMovie(@PathVariable UUID id){
//         movieService.deleteSingleMovie(id);
//    }
}