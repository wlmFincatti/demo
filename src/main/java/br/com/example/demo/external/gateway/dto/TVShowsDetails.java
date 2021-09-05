package br.com.example.demo.external.gateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TVShowsDetails extends TVShowsResponse {
    @JsonProperty("created_by")
    private List<CreatedByResponse> createdBy;
    @JsonProperty("episode_run_time")
    private List<Long> episodeRunTime;
    private List<GenreResponse> genres;
    private String homepage;
    @JsonProperty("in_production")
    private Boolean inProduction;
    private List<String> languages;
    @JsonProperty("last_air_date")
    private LocalDate lastAirDate;
    @JsonProperty("last_episode_to_air")
    private LastEpisodeToAirResponse lastEpisodeToAir;
    private List<NetworksResponse> networks;
    @JsonProperty("number_of_episodes")
    private Long numberOfEpisodes;
    @JsonProperty("number_of_seasons")
    private Long numberOfSeasons;
    @JsonProperty("production_companies")
    private List<ProductionCompaniesResponse> productionCompanies;
    @JsonProperty("production_countries")
    private List<ProductionCountriesResponse> productionCountries;
    private List<SeasonsResponse> seasons;
    @JsonProperty("spoken_languages")
    private List<SpokenLanguagesResponse> spokenLanguages;
    private String status;
    private String tagline;
    private String type;
}
