package com.example.wideo.controler;


import com.example.wideo.domain.Movie;
import com.example.wideo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "movie")
public class MovieControler {


    @Autowired
    public MovieService movieService;



    @GetMapping
    public List<Movie> movieList()
    {
        return movieService.getMovies();
    }





}
