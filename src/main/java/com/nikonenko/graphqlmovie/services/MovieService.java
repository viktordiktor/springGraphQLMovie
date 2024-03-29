package com.nikonenko.graphqlmovie.services;

import com.nikonenko.graphqlmovie.exception.MovieNotFoundException;
import com.nikonenko.graphqlmovie.models.Movie;
import com.nikonenko.graphqlmovie.models.MovieRequest;
import com.nikonenko.graphqlmovie.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieService {
    private final MovieRepository movieRepository;
    private final ModelMapper modelMapper;

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Movie getMovieByID(Long id){
        return movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Can't find movie by ID!"));
    }

    public Movie saveMovie(MovieRequest movieRequest) {
        Movie movie = modelMapper.map(movieRequest, Movie.class);
        log.info("Saving movie {}", movie.getTitle());
        return movieRepository.save(movie);
    }

    public Movie editMovie(Long id, MovieRequest movieRequest) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Can't find movie by ID!"));
        modelMapper.map(movieRequest, movie);
        log.info("Saving movie {}", movie.getTitle());
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Can't find movie by ID!"));
        log.info("Deleting movie {}", movie.getTitle());
        movieRepository.delete(movie);
    }
}
