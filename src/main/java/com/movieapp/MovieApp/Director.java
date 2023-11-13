package com.movieapp.MovieApp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="Directors", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Director {
    @Id
    @GeneratedValue
    private UUID directorId;
    private String firstName;
    private String lastName;
    private LocalDate date_of_birth;
    private String address;
    private String nationality;
    private String email;
    private String gender;
    @ManyToOne
    @JoinColumn(name = "studio_id")
    Studio studio;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    Movie movie;
}
