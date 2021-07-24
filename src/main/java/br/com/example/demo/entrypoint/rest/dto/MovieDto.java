package br.com.example.demo.entrypoint.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private Long id;
    private String overview;
    private String popularity;
    private LocalDate releaseDate;
    private Double voteAverage;
    private String title;
}
