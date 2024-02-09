package com.movieapp.MovieApp.service;

import com.movieapp.MovieApp.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {

    public String makePayment();
    public  String authorizePayment();
}
