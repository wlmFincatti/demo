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
public class LastEpisodeToAirResponse {
    @JsonProperty("air_date")
    private LocalDate airDate;
    @JsonProperty("episode_number")
    private Long episodeNumber;
    private Long id;
    private String name;
    private String overview;
    @JsonProperty("production_code")
    private String productionCode;
    @JsonProperty("season_number")
    private Long seasonNumber;
    @JsonProperty("still_path")
    private String stillPath;
    @JsonProperty("vote_average")
    private Double voteAverage;
    @JsonProperty("vote_count")
    private Long voteCount;
}
