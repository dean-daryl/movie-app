package com.movieapp.MovieApp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movies",schema = "public")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID movieId;
    private String movieName;
    private String trailerLink;
    private LocalDate releaseDate;
    private Integer views;
    @ManyToMany
    @JoinTable(name = "Movie Genres")
    List<Genres> genres;
    @OneToMany(mappedBy="movie")
    List<MovieAward> movieAwards;
    @ManyToMany
    @JoinTable(
            name = "movie_actor",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private  List<Actor> movieActors;
    @OneToMany(mappedBy="movie")
    List<Reviews> reviews;
    @OneToMany(mappedBy="movie")
    List<Studio> studios;
    @OneToMany(mappedBy="movie")
    List<Director> directors;


}