package com.nikonenko.graphqlmovie.repositories;

import com.nikonenko.graphqlmovie.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMovieRepository extends JpaRepository<Movie, Long> {
}
