package br.com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class Movie {
    private Long id;
    private String overview;
    private String popularity;
    private String posterPath;
    private LocalDate releaseDate;
    private String title;
    private Double voteAverage;
    private Long voteCount;
}
