package br.com.example.demo.fixture.responses;

import br.com.example.demo.external.gateway.dto.MovieDetailsResponse;
import br.com.example.demo.util.FixtureUtils;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@UtilityClass
public class MovieDetailsResponseFixture {
    private static final String FILE = "fixture/responses/MovieDetailsResponse.json";

    public static MovieDetailsResponse gimmeMovieDetailsResponseFromJson() {
        try {
            return FixtureUtils.parseObject(FILE, MovieDetailsResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static MovieDetailsResponse gimmeMovieDetailsResponse() {
        return MovieDetailsResponse.builder()
            .adult(false)
            .backdropPath("")
            .budget(1L)
            .genres(Collections.emptyList())
            .homepage("")
            .id(1L)
            .imdbId("")
            .originalLanguage("")
            .originalTitle("")
            .overview("")
            .popularity("1.0")
            .posterPath("")
            .productionCompanies(Collections.emptyList())
            .productionCountries(Collections.emptyList())
            .releaseDate(LocalDate.now())
            .revenue(1L)
            .runtime(1L)
            .spokenLanguages(Collections.emptyList())
            .status("")
            .tagline("")
            .title("")
            .video(false)
            .voteAverage(1.0)
            .voteCount(1L)
            .build();
    }
}
