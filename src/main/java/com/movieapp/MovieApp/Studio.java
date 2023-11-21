package com.movieapp.MovieApp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="Studios", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Studio {
    @Id
    @GeneratedValue
    private UUID studioId;
    private String studioName;
    private String address;
    private String country;
    @OneToMany(mappedBy = "studio",cascade = CascadeType.ALL)
    private List<Director> directors;
    @ManyToOne
    @JoinColumn(name = "movieId")
    Movie movie;
}
