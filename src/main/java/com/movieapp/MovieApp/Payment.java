package com.movieapp.MovieApp;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Table(name = "Payments")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue
    private UUID paymentId;
    private String paymentMethod;
    private LocalDate paymentDate;
    private String amountPaid;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
