package br.com.example.demo.fixture.responses;

import br.com.example.demo.external.gateway.dto.TVShowsResponse;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@UtilityClass
public class TVShowsResponseFixture {
    public static List<TVShowsResponse> gimmeTVShowsResponseList() {
        return Collections.singletonList(gimmeTVShowResponse());
    }

    private static TVShowsResponse gimmeTVShowResponse() {
        return TVShowsResponse.builder()
            .firstAirDate(LocalDate.of(2010, 11, 15))
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
