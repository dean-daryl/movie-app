package com.movieapp.MovieApp;

import java.time.LocalDate;
import java.util.UUID;

public record MovieRecord(  UUID movieId, LocalDate release_date, String movieName, Integer views) {

}
