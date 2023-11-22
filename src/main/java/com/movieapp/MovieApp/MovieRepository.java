package com.movieapp.MovieApp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface MovieRepository extends JpaRepository<Movie, UUID> {
//    Pagination
    @Query(value = "SELECT m from Movie m")
    Page<Movie> getAllMovies(Pageable pageable);

    @Query(value = "SELECT m FROM Movie m WHERE m.movieId = :movie_id")
    Optional<Movie> getSingleMovieById(@Param("movie_id") UUID movie_id);
    @Query(value = "SELECT m FROM Movie m WHERE m.movieName = :movieName")
    Optional<Movie> getSingleMovieByName(@Param("movieName") String movieName);


}
