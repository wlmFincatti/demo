package br.com.example.demo.external.gateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SeasonsResponse {
    @JsonProperty("air_date")
    private LocalDate airDate;
    @JsonProperty("episode_count")
    private Long episodeCount;
    private Long id;
    private String name;
    private String overview;
    @JsonProperty("poster_path")
    private String poster_path;
    @JsonProperty("season_number")
    private Long seasonNumber;
}
