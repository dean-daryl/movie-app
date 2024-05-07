package com.movieapp.MovieApp.service;

import com.movieapp.MovieApp.model.Studio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface StudioService {
    public Studio createStudio(Studio studio);
    public Page<Studio> getAllStudios(Pageable pageable);
    public Studio getSingleStudio(UUID id);
    public List<Studio>findByStudioName(String studioName);
}
