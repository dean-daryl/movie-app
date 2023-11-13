package com.movieapp.MovieApp;

import org.springframework.stereotype.Service;

@Service
public interface MovieService {
    Movie createMovie(Movie movie);
}
