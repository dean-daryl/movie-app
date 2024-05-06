package com.movieapp.MovieApp.model;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.util.UUID;

@Getter
@Setter
@Document(indexName = "studio", createIndex = true)
public class Studio{
    @Id
    private String id;
    @Field
    private String studioName;

}