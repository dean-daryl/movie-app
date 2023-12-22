package com.movieapp.MovieApp.controller;

import com.movieapp.MovieApp.model.User;
import com.movieapp.MovieApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/create")
    public User createUser(@RequestBody User user){
       return userService.createUser(user);
    }
    @GetMapping("/all")
    public ResponseEntity<Page<User>> getAllUsers(Pageable pageable){
       return userService.getAllUsers(pageable);
    }
}
