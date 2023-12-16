package com.movieapp.MovieApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<MovieRecord> getAllMovies(){
//        Pageable pageable1 = PageRequest.of(1,1, Sort.unsorted());
        return movieRepository.getMoviesByReleaseDateMovieNameAndViews();
    }
    public Optional<Movie>getSingleMovie(UUID movie_id){
        return movieRepository.getSingleMovieById(movie_id);
    }
//    public String deleteSingleMovie(UUID movie_id){
//        try {
//            movieRepository.deleteById(movie_id);
//        }
//        catch (e){
//            return "Something went wrong"
//        }
//         return "Deleted Successfully";
//
//    }
}
