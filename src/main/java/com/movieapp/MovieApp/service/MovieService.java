package com.movieapp.MovieApp.service;

import com.movieapp.MovieApp.MovieRecord;
import com.movieapp.MovieApp.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface MovieService {
    Movie addMovie(Movie movie);

    List<MovieRecord> getAllMovies();

    Optional<Movie> getSingleMovie(UUID movie_id);

    Movie addGenreToMovie(UUID genre_id, UUID movie_id);
    String deleteMovie(UUID movie_id);
}
