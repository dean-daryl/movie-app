package com.movieapp.MovieApp.core.service.implementation;

import com.movieapp.MovieApp.MovieAppApplication;
import com.movieapp.MovieApp.model.Movie;
import com.movieapp.MovieApp.repository.MovieRepository;
import com.movieapp.MovieApp.service.MovieService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = MovieAppApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-test.properties")
class MovieServiceImplTest {
    @Autowired
    MovieService movieService;
    @Autowired
    MovieRepository movieRepository;
    Movie addedMovie;
    Movie testMovie = new Movie(UUID.randomUUID(), LocalDate.now(), "Fast X",10);

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testAddMovie() {
    addedMovie = movieService.addMovie(testMovie);
    Assertions.assertNotNull(addedMovie);
    }
    @Test
    void testDeleteMovie(){
        UUID movie_id = testMovie.getMovieId();
        Optional<Movie> movie = movieRepository.getSingleMovieByName("Fast X");
        if(movie.isPresent())
        {
           String response = movieService.deleteMovie(movie.get().getMovieId());
           Assertions.assertEquals("Successfully deleted movie", response);
        }
    }

}