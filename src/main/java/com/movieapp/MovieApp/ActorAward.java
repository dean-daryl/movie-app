package com.movieapp.MovieApp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "actor awards",schema = "public")
public class ActorAward {
    @Id
    @GeneratedValue
    private UUID awardId;
    private String awardName;
    private String year;
    @ManyToOne
    @JoinColumn(name = "actorId")
    Actor actor;

}
