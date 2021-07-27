package br.com.example.demo.usecase;

import br.com.example.demo.domain.TVShows;
import br.com.example.demo.external.gateway.TMDBGateway;
import br.com.example.demo.fixture.responses.TVShowsResponseFixture;
import br.com.example.demo.usecase.impl.GetPopularTVShowsImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GetPopularTVShowsImplTest {
    private TMDBGateway tmdbGateway;
    private GetPopularTVShows getPopularTVShows;

    @BeforeEach
    void setUp() {
        tmdbGateway = mock(TMDBGateway.class);
        getPopularTVShows = new GetPopularTVShowsImpl(tmdbGateway);
    }

    @Test
    void shouldReturnTVShowsList() {
        // given
        var tvShowsResponses = TVShowsResponseFixture.gimmeTVShowsResponseList();

        // when
        when(tmdbGateway.getPopularTVShows(anyInt())).thenReturn(tvShowsResponses);

        // then
        var tvShows = getPopularTVShows.execute(eq(1));

        assertNotNull(tvShows);
        assertEquals(tvShows.size(), tvShowsResponses.size());
    }
}
