package com.movieapp.MovieApp.repository;

import com.movieapp.MovieApp.model.Studio;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.UUID;

public interface StudioRepository extends ElasticsearchRepository<Studio, UUID> {
    List<Studio> findByStudioName(String studioName);
}
