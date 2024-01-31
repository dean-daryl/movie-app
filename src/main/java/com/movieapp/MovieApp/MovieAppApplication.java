package com.movieapp.MovieApp;

import com.movieapp.MovieApp.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MovieAppApplication implements CommandLineRunner {
	@Autowired
	private StateMachine<Payment.PaymentState, Payment.PaymentEvent> stateMachine;
	public static void main(String[] args) {
		SpringApplication.run(MovieAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	stateMachine.sendEvent(Payment.PaymentEvent.PRE_AUTHORIZE);
	stateMachine.sendEvent(Payment.PaymentEvent.AUTHORIZE);
	}
}
