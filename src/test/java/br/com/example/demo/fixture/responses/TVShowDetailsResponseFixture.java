package br.com.example.demo.fixture.responses;

import br.com.example.demo.external.gateway.dto.LastEpisodeToAirResponse;
import lombok.experimental.UtilityClass;
import br.com.example.demo.external.gateway.dto.TVShowsDetails;

import java.time.LocalDate;
import java.util.Collections;

@UtilityClass
public class TVShowDetailsResponseFixture {
    public static TVShowsDetails gimmeTVShowDetailsResponse() {
        return TVShowsDetails.builder()
            .createdBy(Collections.emptyList())
            .episodeRunTime(Collections.emptyList())
            .genres(Collections.emptyList())
            .homepage("")
            .inProduction(false)
            .languages(Collections.emptyList())
            .lastAirDate(LocalDate.now())
            .lastEpisodeToAir(LastEpisodeToAirResponse.builder().build())
            .networks(Collections.emptyList())
            .numberOfEpisodes(1L)
            .numberOfSeasons(1L)
            .productionCompanies(Collections.emptyList())
            .productionCountries(Collections.emptyList())
            .seasons(Collections.emptyList())
            .spokenLanguages(Collections.emptyList())
            .status("")
            .tagline("")
            .type("")
            .firstAirDate(LocalDate.now())
            .name("")
            .originCountry(Collections.emptyList())
            .originalName("")
            .backdropPath("")
            .genreIds(Collections.emptyList())
            .id(1L)
            .originalLanguage("")
            .overview("")
            .popularity("1L")
            .posterPath("")
            .voteAverage(1.0)
            .voteCount(1L)
            .build();
    }
}
