package com.movieapp.MovieApp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "Genres")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Genres {
    @Id
    @GeneratedValue
    private UUID genreId;
    private String genreName;
    private String description;

}
