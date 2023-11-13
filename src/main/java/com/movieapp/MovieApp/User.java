package com.movieapp.MovieApp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "users", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue
    private UUID user_id;
    private String firstName;
    private String lastName;
    private LocalDate date_of_birth;
    private String address;
    private String nationality;
    private String email;
    private String gender;
    private String country_code;
    private String phone_number;
    private String password;
    @OneToMany
    private List<PaymentPlan> plans;
    @OneToMany
    Collection<Role> roles;
    @OneToMany
    Collection<Payment> payments;
    @OneToMany
    Collection<Account> accounts;
    @OneToMany
    Collection<Notification> notifications;
}
