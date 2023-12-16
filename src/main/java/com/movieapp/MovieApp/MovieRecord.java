package com.movieapp.MovieApp;

import java.time.LocalDate;
import java.util.UUID;

public record MovieRecord(LocalDate release_date, String movieName, Integer views) {

}
