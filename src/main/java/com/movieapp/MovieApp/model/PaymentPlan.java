package com.movieapp.MovieApp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "Payment Plans", schema = "public")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
public class PaymentPlan {
    @Id
    @GeneratedValue
    private UUID paymentPlanId;
    private String paymentPlanName;
    private String paymentPlanPrice;
    private String duration;
    private Boolean active;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
