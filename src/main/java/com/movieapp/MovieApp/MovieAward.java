package com.movieapp.MovieApp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="MovieAwards")
public class MovieAward {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID awardId;
    private String award_name;
    private String year;
    @ManyToOne
    @JoinColumn(name="movie_id")
    Movie movie;

}
