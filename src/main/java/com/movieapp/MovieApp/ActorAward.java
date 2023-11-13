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
    private UUID award_id;
    private String award_name;
    private String year;
    @ManyToOne
    @JoinColumn(name = "actor_id")
    Actor actor;

}
