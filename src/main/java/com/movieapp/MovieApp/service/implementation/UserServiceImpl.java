package com.movieapp.MovieApp.service.implementation;

import com.movieapp.MovieApp.model.User;
import com.movieapp.MovieApp.repository.UserRepository;
import com.movieapp.MovieApp.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseEntity<String> deleteUser(UUID user_id) {
        return null;
    }

    @Override
    public ResponseEntity<User> editUser(UUID user_id) {
        return null;
    }

    @Override
    public ResponseEntity<Page<User>> getAllUsers(Pageable pageable) {
        Page<User> users =  userRepository.getAllUsers(pageable);
        return ResponseEntity.ok(users);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow();
    }
}
