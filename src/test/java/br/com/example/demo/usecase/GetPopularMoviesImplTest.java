package br.com.example.demo.usecase;

import br.com.example.demo.domain.Movie;
import br.com.example.demo.external.gateway.TMDBGateway;
import br.com.example.demo.fixture.responses.MoviesResponseFixture;
import br.com.example.demo.usecase.impl.GetPopularMoviesImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GetPopularMoviesImplTest {
    private TMDBGateway tmdbGateway;
    private GetPopularMovies getPopularMovies;

    @BeforeEach
    void setUp() {
        tmdbGateway = mock(TMDBGateway.class);
        getPopularMovies = new GetPopularMoviesImpl(tmdbGateway);
    }

    @Test
    void shouldReturnAMovieList() {
        // given
        var movieResponse = MoviesResponseFixture.gimmeMoviesResponse();

        // when
        when(tmdbGateway.getPopularMovies(anyInt())).thenReturn(movieResponse);

        // then
        var movies = getPopularMovies.execute(eq(1));

        assertNotNull(movies);
        assertEquals(movieResponse.size(), movies.size());
        assertEquals(movieResponse.get(0).getId(), movies.get(0).getId());
        assertEquals(movieResponse.get(0).getReleaseDate(), movies.get(0).getReleaseDate());
    }
}
