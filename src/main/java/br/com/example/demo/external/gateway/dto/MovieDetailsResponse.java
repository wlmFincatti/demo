package br.com.example.demo.external.gateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class MovieDetailsResponse extends MovieResponse {
    private Long budget;
    private List<GenreResponse> genres;
    private String homepage;
    @JsonProperty("imdb_id")
    private String imdbId;
    @JsonProperty("production_companies")
    private List<ProductionCompaniesResponse> productionCompanies;
    @JsonProperty("production_countries")
    private List<ProductionCountriesResponse> productionCountries;
    private Long revenue;
    private Long runtime;
    @JsonProperty("spoken_languages")
    private List<SpokenLanguagesResponse> spokenLanguages;
    private String status;
    private String tagline;
}
