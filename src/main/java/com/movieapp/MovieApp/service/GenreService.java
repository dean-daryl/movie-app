package com.movieapp.MovieApp.service;

import com.movieapp.MovieApp.model.Genres;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GenreService {
    Genres addGenre(Genres genres);
    Page<Genres> getAllGenres(Pageable pageable);
}
