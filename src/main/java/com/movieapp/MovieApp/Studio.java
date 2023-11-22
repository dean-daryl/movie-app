package com.movieapp.MovieApp;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Table(name="Studios", schema = "public")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Studio {
    @Id
    @GeneratedValue
    private UUID studioId;
    private String studioName;
    private String address;
    private String country;
    @OneToMany(mappedBy = "studio",cascade = CascadeType.PERSIST)
    private List<Director> directors;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    Movie movie;
}
