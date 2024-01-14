package com.nikonenko.graphqlmovie.controllers;

import com.nikonenko.graphqlmovie.models.Movie;
import com.nikonenko.graphqlmovie.models.MovieRequest;
import com.nikonenko.graphqlmovie.services.MovieService;
import com.nikonenko.graphqlmovie.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
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

    @MutationMapping("addMovie")
    public Movie addMovie(@Argument MovieRequest movieRequest){
        return movieService.saveMovie(movieRequest);
    }

    @MutationMapping("editMovie")
    public Movie editMovie(@Argument Long id, @Argument MovieRequest movieRequest){
        return movieService.editMovie(id, movieRequest);
    }

    @MutationMapping("deleteMovie")
    public ApiResponse deleteMovie(@Argument Long id){
        movieService.deleteMovie(id);
        return new ApiResponse("Movie successfully deleted!", true);
    }
}
