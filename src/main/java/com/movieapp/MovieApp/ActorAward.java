package com.movieapp.MovieApp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@Table(name = "actor awards",schema = "public")
public class ActorAward {
    @Id
    @GeneratedValue
    private UUID awardId;
    private String awardName;
    private String year;
    private UUID actorId;
}
