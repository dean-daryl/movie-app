package com.movieapp.MovieApp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "Reviews")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reviews {
    @Id
    @GeneratedValue
    private UUID review_id;
    private String review_body;
    private Integer rating;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

}
