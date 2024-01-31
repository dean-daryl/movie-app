package com.movieapp.MovieApp.repository;

import com.movieapp.MovieApp.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {
}
