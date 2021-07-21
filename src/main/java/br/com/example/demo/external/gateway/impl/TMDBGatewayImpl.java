package br.com.example.demo.external.gateway.impl;

import br.com.example.demo.external.client.TMDBClient;
import br.com.example.demo.external.client.TMDBClientParams;
import br.com.example.demo.external.gateway.TMDBGateway;
import br.com.example.demo.external.gateway.dto.MovieResponse;
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
    public List<MovieResponse> getPopularMovies() {
        return this.getPopularMovies(1);
    }

    @Override
    public List<MovieResponse> getPopularMovies(Integer page) {
        return tmdbClient.getPopularMovies(new TMDBClientParams(apiKey, page)).getResults();
    }
}
