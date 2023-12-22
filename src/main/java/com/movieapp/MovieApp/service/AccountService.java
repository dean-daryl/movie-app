package com.movieapp.MovieApp.service;

import com.movieapp.MovieApp.model.Account;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface AccountService {
    public Account addAccount(Account account, UUID user_id);
    public ResponseEntity<String> deleteAccount(UUID account_id);


}
