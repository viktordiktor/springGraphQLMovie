package com.nikonenko.graphqlmovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class GraphqlMovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlMovieApplication.class, args);
	}

}
