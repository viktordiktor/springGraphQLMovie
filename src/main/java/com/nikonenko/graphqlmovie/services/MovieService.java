package com.nikonenko.graphqlmovie.services;

import com.nikonenko.graphqlmovie.exception.MovieNotFoundException;
import com.nikonenko.graphqlmovie.models.Movie;
import com.nikonenko.graphqlmovie.models.MovieRequest;
import com.nikonenko.graphqlmovie.repositories.JpaMovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieService {
    private final JpaMovieRepository jpaMovieRepository;
    private final ModelMapper modelMapper;

    public List<Movie> getAllMovies(){
        return jpaMovieRepository.findAll();
    }

    @Cacheable(key = "#id", value ="MOVIE")
    public Movie getMovieByID(Long id){
        return jpaMovieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Can't find movie by ID!"));
    }

    public Movie saveMovie(MovieRequest movieRequest) {
        Movie movie = modelMapper.map(movieRequest, Movie.class);
        log.info("Saving movie {}", movie.getTitle());
        return jpaMovieRepository.save(movie);
    }

    @CacheEvict(key = "#id", value = "MOVIE")
    public Movie editMovie(Long id, MovieRequest movieRequest) {
        Movie movie = jpaMovieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Can't find movie by ID!"));
        modelMapper.map(movieRequest, movie);
        log.info("Saving movie {}", movie.getTitle());
        return jpaMovieRepository.save(movie);
    }

    @CacheEvict(key = "#id", value = "MOVIE")
    public void deleteMovie(Long id) {
        Movie movie = jpaMovieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Can't find movie by ID!"));
        log.info("Deleting movie {}", movie.getTitle());
        jpaMovieRepository.delete(movie);
    }
}
