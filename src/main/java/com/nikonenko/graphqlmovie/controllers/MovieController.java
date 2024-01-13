package com.nikonenko.graphqlmovie.controllers;

import com.nikonenko.graphqlmovie.models.Movie;
import com.nikonenko.graphqlmovie.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;


@Controller
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @QueryMapping("getAllMovies")
    public Iterable<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @QueryMapping("getMovie")
    public Movie getMovieById(@Argument Long id){
        return movieService.getMovieByID(id);
    }
}
