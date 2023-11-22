package com.movieapp.MovieApp;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@Table(name = "Accounts")
public class Account {
    @Id
    @GeneratedValue
    private UUID accountId;
    private String accountName;
    private enum Category {
        kids,
        normal,
    };
    @Enumerated(EnumType.STRING)
    private Category category;
    private Boolean active;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
