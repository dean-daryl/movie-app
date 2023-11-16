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
    private UUID reviewId;
    private String reviewBody;
    private Integer rating;
    @ManyToOne
    @JoinColumn(name = "movieId")
    private Movie movie;

}
