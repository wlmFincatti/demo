package br.com.example.demo.external.gateway.impl;

import br.com.example.demo.external.client.TMDBClient;
import br.com.example.demo.external.client.TMDBClientParams;
import br.com.example.demo.external.gateway.TMDBGateway;
import br.com.example.demo.external.gateway.dto.MovieResponse;
import br.com.example.demo.external.gateway.dto.TVShowsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TMDBGatewayImpl implements TMDBGateway {

    private final TMDBClient tmdbClient;
    @Value("${tmdb.api.key}")
    private String apiKey;

    @Override
    public List<MovieResponse> getPopularMovies(Integer page) {
        return tmdbClient.getPopularMovies(new TMDBClientParams(apiKey, page)).getResults();
    }

    @Override
    public List<MovieResponse> getTopRatedMovies(Integer page) {
        return tmdbClient.getTopRatedMovies(new TMDBClientParams(apiKey, page)).getResults();
    }

    @Override
    public List<TVShowsResponse> getPopularTVShows(Integer page) {
        return tmdbClient.getPopularTVShows(new TMDBClientParams(apiKey, page)).getResults();
    }

    @Override
    public List<TVShowsResponse> getTopRatedTVShows(Integer page) {
        return tmdbClient.getTopRatedTVShows(new TMDBClientParams(apiKey, page)).getResults();
    }
}
