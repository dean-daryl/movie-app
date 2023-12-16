package com.movieapp.MovieApp;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movies", schema = "public")
public class Movie {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID movieId;

    private String movieName;
    @JsonAlias({ "youtubeLink"})
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String trailerLink;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate releaseDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer views;
    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "Movie Genres")
    List<Genres> genres;
    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    @OneToMany(mappedBy = "movie", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    List<MovieAward> movieAwards;
    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    @ManyToMany
    @JoinTable(
            name = "movie_actor",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> movieActors;

    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    List<Reviews> reviews;

    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    @OneToMany(mappedBy = "movie", cascade = CascadeType.PERSIST)
    List<Studio> studios;
    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    @OneToMany(mappedBy = "movie", cascade = CascadeType.PERSIST)
    List<Director> directors;

    public Movie(LocalDate releaseDate, String movieName, Integer views) {
        this.releaseDate = releaseDate;
        this.movieName = movieName;
        this.views = views;
    }

    @JsonGetter("movieName")
    public String getMovieName() {
        return movieName;
    }
}
