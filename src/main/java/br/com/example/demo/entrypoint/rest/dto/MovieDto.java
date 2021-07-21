package br.com.example.demo.entrypoint.rest.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class MovieDto {
    private Long id;
    private String overview;
    private String popularity;
    private LocalDate releaseDate;
    private String title;
}
