package br.com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TVShows {
    private Long id;
    private String overview;
    private String popularity;
    private String posterPath;
    private Double voteAverage;
    private Long voteCount;
    private LocalDate firstAirDate;
    private String name;
    private String originalName;
}
