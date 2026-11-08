package org.telusko.movie_suggestor.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.telusko.movie_suggestor.model.MovieMatch;
import org.telusko.movie_suggestor.services.MovieService;

import java.util.List;

@RestController("/api")
@CrossOrigin
public class Endpoints {

    private final MovieService movieService;


    private Endpoints(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/search")
    public List<MovieMatch> search(@RequestParam String query)
    {
        return movieService.search(query);
    }

    @PostMapping("/similarMovie")
    public List<MovieMatch> similarMovies(@RequestParam String query)
    {
        return movieService.similarMovies(query);
    }

}
