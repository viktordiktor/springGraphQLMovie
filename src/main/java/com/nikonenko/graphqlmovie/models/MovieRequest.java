package com.nikonenko.graphqlmovie.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequest {
    private String title;
    private String director;
    private Integer releaseYear;
    private List<String> movieCast;
}
