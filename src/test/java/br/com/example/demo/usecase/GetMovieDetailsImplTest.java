package br.com.example.demo.usecase;

import br.com.example.demo.config.exceptions.ApiException;
import br.com.example.demo.config.exceptions.MovieNotFoundException;
import br.com.example.demo.external.gateway.TMDBGateway;
import br.com.example.demo.fixture.responses.MovieDetailsResponseFixture;
import br.com.example.demo.usecase.impl.GetMovieDetailsImpl;
import feign.FeignException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GetMovieDetailsImplTest {
    private TMDBGateway tmdbGateway;
    private GetMovieDetails getMovieDetails;

    @BeforeEach
    void setUp() {
        tmdbGateway = mock(TMDBGateway.class);
        getMovieDetails = new GetMovieDetailsImpl(tmdbGateway);
    }

    @Test
    void shouldReturnAMovieDetailsWhenMovieIdIsValid() {
        // given
        Long id = 1L;
        var movieDetailsResponse = MovieDetailsResponseFixture.gimmeMovieDetailsResponse();

        // when
        when(tmdbGateway.getMovieDetails(id)).thenReturn(movieDetailsResponse);

        // then
        var movieDetailsDto = getMovieDetails.execute(id);

        assertNotNull(movieDetailsDto);
        assertEquals(movieDetailsResponse.getHomepage(), movieDetailsDto.getHomepage());
        assertEquals(movieDetailsResponse.getRuntime(), movieDetailsDto.getRuntime());
        assertEquals(movieDetailsResponse.getSpokenLanguages().size(),
            movieDetailsResponse.getSpokenLanguages().size());
        assertEquals(movieDetailsResponse.getStatus(), movieDetailsDto.getStatus());
        assertEquals(movieDetailsResponse.getTagline(), movieDetailsDto.getTagline());
    }

    @Test
    void shouldThrowMovieNotFoundExceptionWhenMovieIdIsNotValidAndStatusCodeIs404() {
        // when
        when(tmdbGateway.getMovieDetails(anyLong())).thenThrow(FeignException.NotFound.class);

        // then
        try {
            getMovieDetails.execute(eq(1L));
            fail();
        } catch (MovieNotFoundException e) {
            assertTrue(true);
        } catch (ApiException e) {
            fail();
        }

    }

    @Test
    void shouldThrowApiExceptionWhenMovieIdIsNotValidAndStatusCodeIs4xxOr5xx() {
        // when
        when(tmdbGateway.getMovieDetails(anyLong())).thenThrow(FeignException.ServiceUnavailable.class);

        // then
        try {
            getMovieDetails.execute(eq(1L));
            fail();
        } catch (MovieNotFoundException e) {
            fail();
        } catch (ApiException e) {
            assertTrue(true);
        }
    }
}
