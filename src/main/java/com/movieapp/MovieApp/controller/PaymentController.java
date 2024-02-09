package com.movieapp.MovieApp.controller;

import com.movieapp.MovieApp.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payment")
public class PaymentController {
@Autowired
private PaymentService paymentService;
@PostMapping("/make_payments")
public String makePayments() {
    return paymentService.makePayment();
}
@PostMapping("/authorize")
public String authorizePayments(){
    return paymentService.authorizePayment();
}

}
