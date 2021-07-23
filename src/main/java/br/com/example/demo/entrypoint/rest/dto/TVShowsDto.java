package br.com.example.demo.entrypoint.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TVShowsDto {
    private Long id;
    private String overview;
    private String popularity;
    private Double voteAverage;
    private LocalDate firstAirDate;
    private String name;
    private String originalName;
}
