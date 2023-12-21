package com.movieapp.MovieApp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;


@Table(name="notifications")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Notification {
    @Id
    @GeneratedValue
    private UUID notificationId;
    private String title;
    private String message;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDate timeStamp;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
