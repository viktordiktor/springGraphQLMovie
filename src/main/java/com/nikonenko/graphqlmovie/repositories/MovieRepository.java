package com.nikonenko.graphqlmovie.repositories;

import com.nikonenko.graphqlmovie.models.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {
}
