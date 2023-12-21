package com.movieapp.MovieApp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "Genres")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Genres {
    @Id
    @GeneratedValue
    private UUID genreId;
    private String genreName;
    private String description;

}
