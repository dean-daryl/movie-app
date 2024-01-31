package com.movieapp.MovieApp.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Table(name = "Payments")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue
    private UUID paymentId;
    @Enumerated(EnumType.STRING)
    private PaymentState state;
    private String amountPaid;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public enum PaymentState {
        NEW, PRE_AUTH, PRE_AUTH_ERROR, AUTH, AUTH_ERROR
    }
    public enum PaymentEvent{
        PRE_AUTHORIZE, PRE_AUTH_APPROVED, PRE_AUTH_DECLINED, AUTHORIZE, AUTH_APPROVED, AUTH_DECLINED
    }
}
