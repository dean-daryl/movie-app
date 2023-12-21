package com.movieapp.MovieApp.repository;

import com.movieapp.MovieApp.model.Genres;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GenreRepository extends JpaRepository<Genres, UUID> {
}
