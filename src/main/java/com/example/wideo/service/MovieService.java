package com.example.wideo.service;


import com.example.wideo.domain.Movie;
import com.example.wideo.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    public MovieRepo movieRepo;


    public List<Movie> getMovies()
    {
        return movieRepo.findAll();
    }
}
