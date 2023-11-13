package com.movieapp.MovieApp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "Accounts")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {
    @Id
    @GeneratedValue
    private UUID account_id;
    private String account_name;
    private enum Category {
        Kids,
        Normal,
    };
    @Enumerated(EnumType.STRING)
    private Category category;
    private Boolean active;
    @ManyToMany
    Collection<Movie> favorites;
}
