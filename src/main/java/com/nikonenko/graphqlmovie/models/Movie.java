package com.nikonenko.graphqlmovie.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("movie")
public class Movie implements Serializable {
    @Id
    private Long id;

    @Indexed
    private String title;

    @Indexed
    private String director;

    @Indexed
    private Integer releaseYear;

    @Indexed
    private List<String> movieCast;
}
