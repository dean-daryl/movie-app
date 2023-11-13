package com.movieapp.MovieApp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "Genres")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Genres {
    @Id
    @GeneratedValue
    private UUID genre_id;
    private String genre_name;
    private String description;

}
