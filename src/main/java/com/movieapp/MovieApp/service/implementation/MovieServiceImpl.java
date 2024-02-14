package com.movieapp.MovieApp.service.implementation;

import com.movieapp.MovieApp.MovieRecord;
import com.movieapp.MovieApp.model.Genres;
import com.movieapp.MovieApp.model.Movie;
import com.movieapp.MovieApp.repository.GenreRepository;
import com.movieapp.MovieApp.repository.MovieRepository;
import com.movieapp.MovieApp.service.MovieService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @Autowired
    private GenreRepository genreRepository;
    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<MovieRecord> getAllMovies() {
        return movieRepository.getMoviesByReleaseDateMovieNameAndViews();
    }

    @Override
    public ResponseEntity<Movie> getSingleMovie(UUID movie_id) {
        Movie movie =  movieRepository.getSingleMovieById(movie_id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie with such an ID not found"));
        return ResponseEntity.ok(movie);
    }

    @Override
    public Movie addGenreToMovie(UUID genre_id, UUID movie_id) {
            Movie movie = movieRepository.findById(movie_id).orElseThrow(() -> new RuntimeException("Movie with such Id was not found"));
            Genres genre = genreRepository.findById(genre_id).orElseThrow(()-> new RuntimeException("Genre with such Id was not found"));
            List<Genres> genres = movie.getGenres();
            genres.add(genre);
            return movieRepository.save(movie);

    }

    @Override
    public String deleteMovie(UUID movie_id){
        String response="";
        Movie movie = movieRepository.findById(movie_id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie with such ID was not found"));
        if(movie != null){
            try{
                movieRepository.deleteById(movie_id);
                response = "Successfully deleted movie";
            }
            catch (RuntimeException exception){
                response = exception.getMessage();
            }
        }
        return  response;
    }

    @Override
    public ResponseEntity<Movie> getMovieByName(String movie_name) {
        Movie movie = movieRepository.getSingleMovieByName(movie_name).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie with such a Name was not found"));
        return ResponseEntity.ok(movie);
    }
}
