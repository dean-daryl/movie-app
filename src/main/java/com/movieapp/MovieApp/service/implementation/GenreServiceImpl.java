package com.movieapp.MovieApp.service.implementation;

import com.movieapp.MovieApp.model.Genres;
import com.movieapp.MovieApp.repository.GenreRepository;
import com.movieapp.MovieApp.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    GenreRepository genreRepository;
    @Override
    public Genres addGenre(Genres genre) {
        return genreRepository.save(genre);
    }

    @Override
    public Page<Genres> getAllGenres(Pageable pageable) {
        return genreRepository.findAll(pageable);
    }
}
