package com.movieapp.MovieApp.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "users", schema = "public")
@Data
@JsonRootName(value = "user")
@JsonIgnoreProperties({"password"})
public class User implements UserDetails{
    @Id
    @GeneratedValue
    private UUID userId;
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
    private String role;
    @JsonProperty(value = "password", access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<PaymentPlan> plans;
//    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
//    private List<Role> roles;
    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<Payment> payments;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Account> accounts;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Notification> notifications;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String Password){
        this.password = password;
    }
    public void setRole(String Role){
        this.role = role;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

    public String getPassword() {
        return this.password;
    }
    public UUID getId()
    {
        return this.userId;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
