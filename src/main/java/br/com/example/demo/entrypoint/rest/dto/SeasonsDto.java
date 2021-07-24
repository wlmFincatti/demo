package br.com.example.demo.entrypoint.rest.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class SeasonsDto {
    private LocalDate airDate;
    private Long episodeCount;
    private Long id;
    private String name;
    private Long seasonNumber;
}
