package com.movieapp.MovieApp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Payments")
@NoArgsConstructor
@AllArgsConstructor
@Data
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
