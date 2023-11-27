package com.movieapp.MovieApp;

import com.fasterxml.jackson.annotation.*;
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
@JsonRootName(value = "user")
@JsonIgnoreProperties({"password"})
public class User {
    @Id
    @GeneratedValue
    private UUID userId;
    @JsonProperty(value = "name", access = JsonProperty.Access.WRITE_ONLY)
    private String firstName;
    private String lastName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;
    private String address;
    private String nationality;
    private String email;
    private String gender;
    private String countryCode;
    private String phoneNumber;
    @JsonProperty(value = "password", access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<PaymentPlan> plans;
    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<Role> roles;
    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<Payment> payments;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Account> accounts;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Notification> notifications;
}
