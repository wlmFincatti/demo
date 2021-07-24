package br.com.example.demo.external.gateway;

import br.com.example.demo.external.gateway.dto.MovieDetailsResponse;
import br.com.example.demo.external.gateway.dto.MovieResponse;
import br.com.example.demo.external.gateway.dto.TVShowsResponse;

import java.util.List;

public interface TMDBGateway {
    List<MovieResponse> getPopularMovies(Integer page);
    List<MovieResponse> getTopRatedMovies(Integer page);
    List<TVShowsResponse> getPopularTVShows(Integer page);
    List<TVShowsResponse> getTopRatedTVShows(Integer page);
    MovieDetailsResponse getMovieDetails(Long id);
}
