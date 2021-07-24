package br.com.example.demo.external.client;

import br.com.example.demo.external.gateway.dto.MovieDetailsResponse;
import br.com.example.demo.external.gateway.dto.TMDBGatewayMoviesResponse;
import br.com.example.demo.external.gateway.dto.TMDBGatewayTVShowsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "tmdbClient", url = "${tmdb.base.url}")
public interface TMDBClient {

    @GetMapping(value = "/movie/popular", consumes = MediaType.APPLICATION_ATOM_XML_VALUE)
    TMDBGatewayMoviesResponse getPopularMovies(@SpringQueryMap TMDBClientParams params);

    @GetMapping(value = "/movie/top_rated")
    TMDBGatewayMoviesResponse getTopRatedMovies(@SpringQueryMap TMDBClientParams params);

    @GetMapping(value = "/tv/popular", consumes = MediaType.APPLICATION_ATOM_XML_VALUE)
    TMDBGatewayTVShowsResponse getPopularTVShows(@SpringQueryMap TMDBClientParams params);

    @GetMapping(value = "/tv/top_rated")
    TMDBGatewayTVShowsResponse getTopRatedTVShows(@SpringQueryMap TMDBClientParams params);

    @GetMapping(value = "/movie/{id}")
    MovieDetailsResponse getMovieDetails(@PathVariable Long id, @SpringQueryMap TMDBClientParams params);
}
