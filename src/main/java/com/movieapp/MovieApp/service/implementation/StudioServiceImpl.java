package com.movieapp.MovieApp.service.implementation;

import com.movieapp.MovieApp.model.Studio;
import com.movieapp.MovieApp.repository.StudioRepository;
import com.movieapp.MovieApp.service.StudioService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class StudioServiceImpl implements StudioService {
    private final StudioRepository studioRepository;

    public StudioServiceImpl(StudioRepository studioRepository) {
        this.studioRepository = studioRepository;
    }

    @Override
    public Studio createStudio(Studio studio) {
        return studioRepository.save(studio);
    }

    @Override
    public Page<Studio> getAllStudios(Pageable pageable) {
        return studioRepository.findAll(pageable);
    }

    @Override
    public Studio getSingleStudio(UUID id) {
        return null;
    }

    @Override
    public List<Studio> findByStudioName(String studioName) {
        return studioRepository.findByStudioName(studioName);
    }
}
