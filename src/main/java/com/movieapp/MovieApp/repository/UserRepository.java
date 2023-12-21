package com.movieapp.MovieApp.repository;

import com.movieapp.MovieApp.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository <User, UUID> {
    @Query(value = "SELECT u FROM User u")
    Page<User> getAllUsers(Pageable pageable);

    @Query( value = "SELECT u, a FROM User u JOIN u.accounts a")
    Page<User> findAllUsersAccounts(Pageable pageable);
    @Query(value = "SELECT u FROM User u WHERE u.userId = :user_id")
    Optional<User> getOneUser(@Param("user_id") UUID user_id);
//    @Query( value = "SELECT u FROM User u WHERE dob < 2005-01-01")
//    Page<User>  findAdultUsers(Pageable pageable);
//    A TO Z
//    @Query( value = "SELECT u.firstName FROM User ORDER BY u.firstName ASC")
//    Page<User> getAllUsersByFirstNameAscendingOrder(Pageable pageable);
////  Z TO A
//    @Query( value = "SELECT u.firstName FROM User ORDER BY u.firstName DESC")
//    Page<User> getAllUsersByFirstNameDescendingOrder(Pageable pageable);
}
