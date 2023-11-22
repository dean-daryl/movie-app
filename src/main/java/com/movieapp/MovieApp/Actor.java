package com.movieapp.MovieApp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@Table(name = "actors",schema = "public")
public class Actor {
    @Id
    @GeneratedValue
    private UUID actorId;
    private String firstName;
    private String lastName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;
    private String address;
    private String nationality;
    private String email;
    private String gender;

    @ManyToMany(mappedBy = "movieActors",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Movie> movies;
}
