package com.movieapp.MovieApp.service.implementation;

import com.movieapp.MovieApp.model.Payment;
import com.movieapp.MovieApp.repository.PaymentRepository;
import com.movieapp.MovieApp.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private StateMachine<Payment.PaymentState, Payment.PaymentEvent> stateMachine;
    @Autowired
    private PaymentRepository paymentRepository;
    @Override
    public String makePayment() {
        try {
            Payment payment = new Payment();
            paymentRepository.save(payment);
            stateMachine.sendEvent(Payment.PaymentEvent.PRE_AUTHORIZE);
            return (" Payment made successfully🎉🎉");
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String authorizePayment() {
        try {
            stateMachine.sendEvent(Payment.PaymentEvent.AUTHORIZE);
            return (" Payment authorized successfully🎉🎉");
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }
}
