package com.movieapp.MovieApp;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Table(name = "Reviews")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Reviews {
    @Id
    @GeneratedValue
    private UUID reviewId;
    private String reviewBody;
    private Integer rating;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

}
