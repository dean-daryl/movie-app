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
@ToString
@NoArgsConstructor
@Table(name = "movies", schema = "public")
public class Movie {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID movieId;

    private String movieName;
    @JsonAlias({ "youtubeLink"})
    private String trailerLink;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate releaseDate;
    private Integer views;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "Movie Genres")
    List<Genres> genres;
    @OneToMany(mappedBy = "movie", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    List<MovieAward> movieAwards;
    @ManyToMany
    @JoinTable(
            name = "movie_actor",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> movieActors;
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    List<Reviews> reviews;
    @OneToMany(mappedBy = "movie", cascade = CascadeType.PERSIST)
    List<Studio> studios;
    @OneToMany(mappedBy = "movie", cascade = CascadeType.PERSIST)
    List<Director> directors;

    public Movie(UUID movieId, String movieName, String trailerLink, LocalDate releaseDate, Integer views) {
        this.movieName = movieName;
        this.trailerLink = trailerLink;
        this.releaseDate = releaseDate;
        this.views = views;
    }

    @JsonGetter("movieName")
    public String getMovieName() {
        return movieName;
    }
}
