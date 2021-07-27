package br.com.example.demo.fixture.responses;

import br.com.example.demo.external.gateway.dto.MovieResponse;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@UtilityClass
public class MoviesResponseFixture {
    public static List<MovieResponse> gimmeMoviesResponse() {
        return Collections.singletonList(gimmeMovieResponse());
    }

    private static MovieResponse gimmeMovieResponse() {
        return MovieResponse.builder()
            .adult(false)
            .originalTitle("")
            .releaseDate(LocalDate.now())
            .title("")
            .video(false)
            .backdropPath("")
            .genreIds(Collections.emptyList())
            .id(1L)
            .originalLanguage("")
            .overview("")
            .popularity("1")
            .posterPath("")
            .voteAverage(1.0)
            .voteCount(1L)
            .build();
    }
}
