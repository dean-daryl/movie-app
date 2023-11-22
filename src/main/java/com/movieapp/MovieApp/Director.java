package com.movieapp.MovieApp;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;


@Table(name="Directors", schema = "public")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Director {
    @Id
    @GeneratedValue
    private UUID directorId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
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
