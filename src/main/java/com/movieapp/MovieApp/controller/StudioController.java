package com.movieapp.MovieApp.controller;

import com.movieapp.MovieApp.model.Studio;
import com.movieapp.MovieApp.service.StudioService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.support.PageableUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("studio")
public class StudioController {
    private final StudioService studioService;

    public StudioController(StudioService studioService) {
        this.studioService = studioService;
    }

    @PostMapping("/create")
    public Studio createStudio(@RequestBody Studio studio){
        return studioService.createStudio(studio);
    }
    @GetMapping("/all")
    public Page<Studio> getAllStudios(){
        return studioService.getAllStudios(Pageable.unpaged());
    }
    @GetMapping("/name")
    public List<Studio> findByName(@RequestHeader String studioName){
        return studioService.findByStudioName(studioName);
    }
}
