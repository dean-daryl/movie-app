package com.movieapp.MovieApp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "Payment Plans", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentPlan {
    @Id
    @GeneratedValue
    private UUID paymentPlanId;
    private String paymentPlanName;
    private String paymentPlanPrice;
    private String duration;
    private Boolean active;
}
