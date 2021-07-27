package br.com.example.demo.usecase;

import br.com.example.demo.domain.Movie;
import br.com.example.demo.external.gateway.TMDBGateway;
import br.com.example.demo.fixture.responses.MoviesResponseFixture;
import br.com.example.demo.usecase.impl.GetTopRatedMoviesImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GetTopRatedMoviesImplTest {
    private TMDBGateway tmdbGateway;
    private GetTopRatedMovies getTopRatedMovies;

    @BeforeEach
    void setUp() {
        tmdbGateway = mock(TMDBGateway.class);
        getTopRatedMovies = new GetTopRatedMoviesImpl(tmdbGateway);
    }

    @Test
    void shouldReturnTopRatedMovies() {
        // given
        var movieResponses = MoviesResponseFixture.gimmeMoviesResponse();

        // when
        when(tmdbGateway.getTopRatedMovies(anyInt())).thenReturn(movieResponses);

        // then
        var movies = getTopRatedMovies.execute(eq(1));

        assertNotNull(movies);
        assertEquals(movieResponses.size(), movies.size());
    }
}
