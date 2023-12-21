package com.movieapp.MovieApp.repository;

import com.movieapp.MovieApp.MovieRecord;
import com.movieapp.MovieApp.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MovieRepository extends JpaRepository<Movie, UUID> {
    @Query("SELECT new com.movieapp.MovieApp.MovieRecord(m.releaseDate, m.movieName, m.views) FROM Movie m")
    List<MovieRecord> getMoviesByReleaseDateMovieNameAndViews();
    @Query(value = "SELECT m FROM Movie m WHERE m.movieId = :movie_id")
    Optional<Movie> getSingleMovieById(@Param("movie_id") UUID movie_id);
    @Query(value = "SELECT m FROM Movie m WHERE m.movieName = :movieName")
    Optional<Movie> getSingleMovieByName(@Param("movieName") String movieName);
}
