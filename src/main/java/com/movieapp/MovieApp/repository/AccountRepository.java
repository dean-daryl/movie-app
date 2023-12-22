package com.movieapp.MovieApp.repository;

import com.movieapp.MovieApp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
}
