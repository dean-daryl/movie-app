package com.movieapp.MovieApp;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "Roles")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue
    private UUID roleId;
    private String roleName;
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
