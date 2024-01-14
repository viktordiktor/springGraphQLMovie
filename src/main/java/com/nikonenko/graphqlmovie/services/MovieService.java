package com.nikonenko.graphqlmovie.services;

import com.nikonenko.graphqlmovie.models.Movie;
import com.nikonenko.graphqlmovie.models.MovieRequest;
import com.nikonenko.graphqlmovie.repositories.MovieRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final ModelMapper modelMapper;

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Movie getMovieByID(Long id){
        if(movieRepository.existsById(id))
            return movieRepository.findById(id).get();
        throw new EntityNotFoundException("Can't find movie by ID!");
    }

    public Movie saveMovie(MovieRequest movieRequest) {
        Movie movie = modelMapper.map(movieRequest, Movie.class);
        return movieRepository.save(movie);
    }
}
