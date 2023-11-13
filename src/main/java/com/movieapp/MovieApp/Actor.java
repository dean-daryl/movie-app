package com.movieapp.MovieApp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "actors",schema = "public")
public class Actor {
    @Id
    @GeneratedValue
    private UUID actor_id;
    private String firstName;
    private String lastName;
    private LocalDate date_of_birth;
    private String address;
    private String nationality;
    private String email;
    private String gender;
    @OneToMany(mappedBy ="actor", cascade = CascadeType.ALL)
    private List<ActorAward> actorAwards;

}
