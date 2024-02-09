package com.movieapp.MovieApp.core;

import com.movieapp.MovieApp.model.Movie;
import com.movieapp.MovieApp.repository.MovieRepository;
import com.movieapp.MovieApp.service.implementation.MovieServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MovieServiceImpl.class})
public class TestMovie {
    @Autowired
    MovieServiceImpl movieService;

    @Test
    public void TestGettingSingleMovieByMovieName(){
        ResponseEntity<Movie> movies = movieService.getMovieByName("Inception 102");
        Assert.assertNotNull(movies);
    }
}
