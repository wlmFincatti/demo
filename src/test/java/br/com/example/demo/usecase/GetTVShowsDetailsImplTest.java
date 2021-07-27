package br.com.example.demo.usecase;

import br.com.example.demo.config.exceptions.ApiException;
import br.com.example.demo.config.exceptions.TVShowNotFoundException;
import br.com.example.demo.external.gateway.TMDBGateway;
import br.com.example.demo.fixture.responses.TVShowDetailsResponseFixture;
import br.com.example.demo.usecase.impl.GetTVShowsDetailsImpl;
import feign.FeignException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GetTVShowsDetailsImplTest {
    private TMDBGateway tmdbGateway;
    private GetTVShowsDetails getTVShowsDetails;

    @BeforeEach
    void setUp() {
        tmdbGateway = mock(TMDBGateway.class);
        getTVShowsDetails = new GetTVShowsDetailsImpl(tmdbGateway);
    }

    @Test
    void shouldReturnTVShowDetailsWhenGatewayIsCalledSuccessfully() {
        // given
        var tvShowDetails = TVShowDetailsResponseFixture.gimmeTVShowDetailsResponse();

        // when
        when(tmdbGateway.getTVShowsDetails(1L)).thenReturn(tvShowDetails);

        // then
        var tvShowsDetailsDto = getTVShowsDetails.execute(1L);

        assertNotNull(tvShowsDetailsDto);
        assertEquals(tvShowDetails.getSeasons().size(), tvShowsDetailsDto.getSeasons().size());
        assertEquals(tvShowDetails.getSpokenLanguages().size(), tvShowsDetailsDto.getSpokenLanguages().size());
    }

    @Test
    void shouldThrowTVShowNotFoundExceptionWhenGatewayReturns404StatusCode() {
        // when
        when(tmdbGateway.getTVShowsDetails(anyLong())).thenThrow(FeignException.NotFound.class);

        // then
        try {
            getTVShowsDetails.execute(eq(1L));
            fail();
        } catch (TVShowNotFoundException e) {
            assertTrue(true);
        } catch (ApiException e) {
            fail();
        }
    }

    @Test
    void shouldThrowApiExceptionWhenGatewayReturns4xxOr5xxStatusCode() {
        // when
        when(tmdbGateway.getTVShowsDetails(anyLong())).thenThrow(FeignException.ServiceUnavailable.class);

        // then
        try {
            getTVShowsDetails.execute(eq(1L));
            fail();
        } catch (TVShowNotFoundException e) {
            fail();
        } catch (ApiException e) {
            assertTrue(true);
        }
    }
}
