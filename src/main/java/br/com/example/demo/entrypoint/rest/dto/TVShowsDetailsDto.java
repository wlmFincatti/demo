package br.com.example.demo.entrypoint.rest.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@SuperBuilder
@Data
public class TVShowsDetailsDto extends TVShowsDto {
    private String homepage;
    private Boolean inProduction;
    private LocalDate lastAirDate;
    private LastEpisodeToAirDto lastEpisodeToAir;
    private Long numberOfEpisodes;
    private Long numberOfSeasons;
    private List<SeasonsDto> seasons;
    private List<SpokenLanguagesDto> spokenLanguages;
    private String status;
    private String tagline;
}
