package br.com.example.demo.external.gateway;

import br.com.example.demo.external.gateway.dto.MovieResponse;

import java.util.List;

public interface TMDBGateway {
    List<MovieResponse> getPopularMovies();
    List<MovieResponse> getPopularMovies(Integer page);
}
