package com.movieapp.MovieApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/movies")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @PostMapping
    public  Movie createMovie(@RequestBody Movie movie){
        return movieRepository.save(movie);
    }
}
